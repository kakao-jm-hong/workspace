package com.jpabook.jpashop.repository;

import com.jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;


    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item); // 신규 등록
        } else {
            // 실무에서는 잘안사용한데...
            em.merge(item); // update 랑 비슷한 것 DB에서 꺼내오고 다시 셋해서 영속성 반영한다. 그래서 바꿔치기 된애를 반환한다. Item merge = em.merge(item); // merge자체가 관리되는 애다.
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
