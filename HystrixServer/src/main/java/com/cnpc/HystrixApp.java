package com.cnpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by 赵梦杰 on 2018/5/29.
 */
@SpringBootApplication
public class HystrixApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApp.class, args);
    }
}
