package com.al.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 缓存
 *
 * @author al
 * @version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RedisServiceMain6379 {
    public static void main(String[] args) {
        SpringApplication.run(RedisServiceMain6379.class, args);
    }
}
