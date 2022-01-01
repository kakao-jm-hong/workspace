package com.jpabook.jpashop.service;


import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
//    @Rollback(value = false) // DB에 저장하고 싶을때 롤백끈기
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        em.flush();
        assertEquals(member, memberRepository.findOne(savedId));
    }

//    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        member2.setName("kim1");

        //when
        memberService.join(member1);
        try{
            memberService.join(member2);
        }catch (IllegalStateException e) {
            return;
        }

        //then
        fail("예외가 바생해야 한다."); // 코드가 돌다 예외가 발생하면 성공한다.
    }

//    JUNIT5 expected exception 방법
//    @Test
//    public void getUserFailure() throws SQLException, ClassNotFoundException {
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//
//        UserDAO dao = context.getBean("userDAO", UserDAO.class);
//        dao.deleteAll();
//        assertThat(dao.getCount()).isEqualTo(0);
//
//        assertThrows(EmptyResultDataAccessException.class, () -> {
//            dao.get("unkown_id");
//        });
//    }



}