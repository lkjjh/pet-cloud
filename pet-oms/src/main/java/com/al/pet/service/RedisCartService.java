package com.al.pet.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("${service.redis.name}")
public interface RedisCartService {
    @GetMapping("/api/redis/cart/save")
    void save(@RequestParam("key") String key, @RequestParam("hashKey") String hashKey,
              @RequestParam("obj") String obj);

    @GetMapping("/api/redis/cart/values/{key}")
    List<String> values(@PathVariable("key") String key);

    @GetMapping("/api/redis/cart/del")
    void del(@RequestParam("key") String key, @RequestParam("keys") String[] keys);
}
