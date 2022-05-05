package com.al.pet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 商品服务
 *
 * @author al
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.al.pet.mapper")
public class PmsServiceMain9030 {
    public static void main(String[] args) {
        SpringApplication.run(PmsServiceMain9030.class, args);
    }
}
