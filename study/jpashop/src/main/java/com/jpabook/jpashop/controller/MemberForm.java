package com.jpabook.jpashop.controller;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "빈것은 안된다.")
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
