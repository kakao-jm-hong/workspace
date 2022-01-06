package com.jpabook.jpashop.api;

import com.jpabook.jpashop.domain.Address;
import com.jpabook.jpashop.domain.Order;
import com.jpabook.jpashop.domain.OrderStatus;
import com.jpabook.jpashop.repository.OrderRepository;
import com.jpabook.jpashop.repository.OrderSearch;
import com.jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto;
import com.jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xToOne(ManyToOne, OneToOne)
 * Order
 * Order -> Member
 * Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;
    private final OrderSimpleQueryRepository orderSimpleQueryRepository;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());


        for (Order order : all) {
            order.getMember().getName(); // 강제 초기화
            order.getDelivery().getAddress(); // 강제 초기화
        }

        return all;
    }

    @GetMapping("/api/v2/simple-orders")
    public List<SimpleOrderDto> orderV2() {
        /**
         * N + 1 문제... 쿼리 stream for 돌때마다 쿼리가 더돔
         * N + 1 -> 1 + 회원 N + 배송 N
         * 그렇다고 LAZY를 EAGER??? 이건 아니다 ㅜ_ㅜ
         * FETCH JOIN이라는 녀석으로 튜닝을 해야한다!
         */
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        List<SimpleOrderDto> list = orders.stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());
        return list;
    }

    @GetMapping("/api/v3/simple-orders")
    public List<SimpleOrderDto> orderV3() {
        List<Order> orders = orderRepository.findAllWithMemberDelivery();
        List<SimpleOrderDto> list = orders.stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());

        return list;
    }

    @GetMapping("/api/v4/simple-orders")
    public List<OrderSimpleQueryDto> orderV4() {
        List<OrderSimpleQueryDto> orderSimpleQueryDtos = orderSimpleQueryRepository.findOrderDtos();
        return orderSimpleQueryDtos;
    }

    @Data
    static class SimpleOrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;

        public SimpleOrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName(); // LAZY 초기화 (영속석 없으면 쿼리날림)
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getMember().getAddress(); // LAZY 초기화 (영속석 없으면 쿼리날림)
        }
    }
}
