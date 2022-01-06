package com.jpabook.jpashop.repository.order.simplequery;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;
    /**
     * 최적화됨, 하지만 재사용성 없음. orderRepository 에 잇음
     * 요 dto를 쓸때만 쓸 수 잇음.
     * new 명령어를 사용해서 jpql의 결과를 DTO로 즉시변환
     * ADMIN API면 사용해도 괜찮을 듯?
     * @return
     */
    public List<OrderSimpleQueryDto> findOrderDtos() {
        return em.createQuery("select new com.jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto(o.id, m.name, o.orderDate, o.status, d.address) from Order o" +
                " join o.member m" +
                " join o.delivery d", OrderSimpleQueryDto.class).getResultList();
    }
}
