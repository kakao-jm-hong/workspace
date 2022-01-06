package com.jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpashopApplication.class, args);
    }

    /**
     * Hibernate5Modul 보다는 DTO 만드는게 더좋음
     * @return 이거 쓰면 포스로딩이라고 지연로딩되어 잇는 애들 강제 쿼리날리고 불러옴 이거안하면 Null 값이고 @bean 자체가없으면 toString 시 에러남
     */
    @Bean
    Hibernate5Module hibernate5Module() {
        Hibernate5Module hibernate5Module = new Hibernate5Module();
//        hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true); // 이거별루임 이거안하면 null
        return hibernate5Module;
    }

}
