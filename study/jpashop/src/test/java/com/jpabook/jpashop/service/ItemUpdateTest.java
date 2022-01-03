package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    public void updateTEst() throws Exception {
        //given
        Book book = em.find(Book.class, 1L);

        book.setName("");

        //when

        //then
    }
}
