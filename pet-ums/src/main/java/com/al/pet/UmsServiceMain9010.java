package com.al.pet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author al
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.al.pet.mapper")
@EnableFeignClients
public class UmsServiceMain9010 {
    public static void main(String[] args) {
        SpringApplication.run(UmsServiceMain9010.class, args);
    }
}
