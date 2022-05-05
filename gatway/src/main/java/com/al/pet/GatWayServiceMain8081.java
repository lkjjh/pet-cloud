package com.al.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author al
 * @version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class GatWayServiceMain8081 {
    public static void main(String[] args) {
        SpringApplication.run(GatWayServiceMain8081.class, args);
    }
}
