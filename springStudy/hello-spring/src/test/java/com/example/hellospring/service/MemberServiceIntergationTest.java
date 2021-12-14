package com.example.hellospring.service;


import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceIntergationTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() throws SQLException {
        //given
        Member member = new Member();
        member.setName("spring22122");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(),findMember.getName());
    }

    @Test
    void 중복_회원_예외() throws SQLException {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");

//        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalAccessError e) {
//            assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");
//        }

    }

    @Test
    void findOne() {
    }
}
