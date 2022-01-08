package com.jpabook.jpashop.repository.order;

import com.jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 놀랍게도 이것만으로 조회를 가능하다 select m from Member m where m.name = :name
    List<Member> findByName(String name);

    // 나머지 필요한거는 override해서 읍읍??

}
