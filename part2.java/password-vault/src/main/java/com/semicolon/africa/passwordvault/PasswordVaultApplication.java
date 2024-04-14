package com.semicolon.africa.passwordvault;

import lombok.experimental.FieldNameConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PasswordVaultApplication {
    public static void main(String[] args) {
        SpringApplication.run(PasswordVaultApplication.class, args);
    }
}
