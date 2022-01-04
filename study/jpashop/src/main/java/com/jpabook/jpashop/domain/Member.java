package com.jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    // 내장 타입
    @Embedded
    private Address address;

//    @JsonIgnore // 조회할 때 이것을 사용해서 안나오게 할 수 있음.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}

