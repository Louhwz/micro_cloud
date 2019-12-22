package com.louhwz.register.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主要进行双数据库的配置测试
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroTestApplication.class, args);
    }
}
