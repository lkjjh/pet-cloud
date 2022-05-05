package com.al.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 身份验证
 *
 * @author al
 * @version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class AuthenticationServiceMain6666 {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServiceMain6666.class, args);
    }
}
