package com.smile.hrsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.smile.hrsys.mapper")
@EnableScheduling
public class HrsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrsysApplication.class, args);
    }

}
