package com.smile.hrsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.smile.hrsys.mapper")
@EnableScheduling
public class HrsysApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        //$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String text = encoder.encode("123");
        System.out.println("text--> " + text);
        SpringApplication.run(HrsysApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HrsysApplication.class);
    }
}
