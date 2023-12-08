package com.springboot.restproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class RestprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestprojectApplication.class, args);
    }

}
