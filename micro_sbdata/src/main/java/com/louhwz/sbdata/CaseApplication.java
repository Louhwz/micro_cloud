package com.louhwz.sbdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Louhwz
 */
@SpringBootApplication
@EnableEurekaClient
public class CaseApplication{
    public static void main(String[] args) {
        SpringApplication.run(CaseApplication.class, args);
    }
}