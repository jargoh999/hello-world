package com.semicolon.africa.zoomlogistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ZoomLogisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZoomLogisticsApplication.class, args);
    }

}
