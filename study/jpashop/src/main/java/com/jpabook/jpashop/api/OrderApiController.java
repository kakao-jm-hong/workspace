package com.jpabook.jpashop.api;


import com.jpabook.jpashop.domain.Address;
import com.jpabook.jpashop.domain.Order;
import com.jpabook.jpashop.domain.OrderItem;
import com.jpabook.jpashop.domain.OrderStatus;
import com.jpabook.jpashop.repository.OrderRepository;
import com.jpabook.jpashop.repository.OrderSearch;
import com.jpabook.jpashop.repository.order.query.OrderFlatDto;
import com.jpabook.jpashop.repository.order.query.OrderQueryDto;
import com.jpabook.jpashop.repository.order.query.OrderQueryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    /**
     * 1. 엔티티 조회 방식으로 우선 접근
     *  1. 페치조인으로 쿼리 수를 최적화
     *  2. 컬렉션 최적화
     *      1. 페이징 필요 batchSize
     *      2. 페이징 필요 X -> 페치조인 사용
     * 2. 엔티티 조회 방식으로 해결이 안되면 DTO 조회 방식
     * 3. DTO 조회 방식으로 안되면 NativeSql or Spring jdbcTemplate'
     * v4~v6 부터는 sql시에 필요한 데이터만 가져오지만 직접 코드로쳐야해서 귀찬타 네트워크상 움직이는 메모리최적화할때 좋음
     * v3에서 fetch의 배치사이즈가 v5에서 맵으로 지랄하는거랑 비슷하다고 생각함
     */
    private final OrderRepository orderRepository;
    private final OrderQueryRepository orderQueryRepository;

    // 엔티티 조회해서 그대로 반환
    @GetMapping("/api/v1/orders")
    public List<Order> orderV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName();
            order.getDelivery().getAddress();
            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream().forEach(o -> o.getItem().getName());
        }

        return all;

    }

    // dto로 반환 하지만 이버전도 성능 아좋음
    @GetMapping("/api/v2/orders")
    public List<OrderDto> orderV2() {
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        List<OrderDto> collect = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());

        return collect;
    }

    // 페치조인으로 성능올림 하지만 페이징안됌..
    @GetMapping("/api/v3/orders")
    public List<OrderDto> orderV3() {
        // to many 데이터 뻥튀기됨 페치조인쓰면 그래서 디스틴트
        // 페이징 불가능
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
        return result;
    }


    //페치조인의 한계를 극복 페이징가능
    @GetMapping("/api/v3.1/orders")
    public List<OrderDto> orderV3_page(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                       @RequestParam(value = "offset", defaultValue = "100") int limit) {
        // to one 관계는 fetch join 스면좋음 안써도  batch size가 해주지만 그래도 to one은 fetch join !
        // 페이징 가능!
        // 100~ 1000이 적절하다.

        // 일단 toOne관계는 fetch join으로 가져오고 나머지 item에 관한건 지연로딩으로 가져온다.
        // 이때 최적화를위해서 batchsize로 최적화

        List<Order> orders = orderRepository.findAllWithMemberDelivery(offset, limit);
        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
        return result;
    }

    /**
     * Query: 루트 1번, 컬렉션 N번 실행
     * ToOne(N:1, 1:1) 관계들은 먼저 조회하고 , ToMany(1:N)관계는 각각 별도로 처리한다.
     *  - 이런 방식을 선택한 이유는 다음과 같음
     *  - ToOne관계는 조인해도 데이터 row 수가 증가하지 않는다.
     *  - ToMany(1:N)관계는 조인하면 row 수가 증가한다.
     * row 수가 증가하지 않는 ToOne 관계는 조인으로 최적화 하기 쉬우므로 한번에 조회하고, ToMany 관계는 최적화 하기 어려우므로
     * findOrderItems() 같은 별도의 메서드로 조회한다.
     */
    @GetMapping("/api/v4/orders")
    public List<OrderQueryDto> ordersV4() {
        return orderQueryRepository.findOrderQueryDtos();
    }

    @GetMapping("/api/v5/orders")
    public List<OrderQueryDto> ordersV5() {
        return orderQueryRepository.findAllByDto_optimization();
    }

    // 장점 : 쿼리 1번
    // 단점 : 페이징 불가능함.
    // 플랫데이터 최적화 방범
    @GetMapping("/api/v6/orders")
    public List<OrderFlatDto> ordersV6() {
        // 스펙에 안맞음 바꿀려면 겁나힘듬..
        return orderQueryRepository.findAllByDto_flat();

    }

    @Data
    static class OrderDto {

        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;
        private List<OrderItemDto> orderItems;

        public OrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();
            orderItems = order.getOrderItems().stream()
                    .map(orderItem -> new OrderItemDto(orderItem))
                    .collect(Collectors.toList());
        }
    }

    @Data
    static class OrderItemDto {

        private String itemName;
        private int orderPrice;
        private int count;

        public OrderItemDto(OrderItem orderItem) {
            itemName = orderItem.getItem().getName();
            orderPrice = orderItem.getOrderPrice();
            count = orderItem.getCount();
        }
    }
}
