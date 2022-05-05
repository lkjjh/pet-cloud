package com.al.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 阿里云服务
 *
 * @author al
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliYunServiceMain9020 {
    public static void main(String[] args) {
        SpringApplication.run(AliYunServiceMain9020.class, args);
    }
}
