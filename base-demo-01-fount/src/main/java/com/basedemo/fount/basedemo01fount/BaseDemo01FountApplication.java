package com.basedemo.fount.basedemo01fount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BaseDemo01FountApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseDemo01FountApplication.class, args);
    }

}
