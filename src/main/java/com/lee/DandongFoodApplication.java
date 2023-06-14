package com.lee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@MapperScan("com.lee.mapper")
@SpringBootApplication
public class DandongFoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(DandongFoodApplication.class, args);
    }

}
