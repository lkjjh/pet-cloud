package com.al.pet.controller;

import com.al.pet.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 操作redis
 *
 * @author al
 * @version 1.0
 */
@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/{key}")
    public Object get(@PathVariable String key) {
        return redisService.get(key);
    }

    @GetMapping("/expire/{key}")
    public Long getExpire(@PathVariable String key) {
        return redisService.getExpire(key);
    }

    @PostMapping("/{key}")
    public Boolean set(@PathVariable String key, @RequestBody Object value) {
        return redisService.set(key, value);
    }

    @GetMapping(value = "set")
    public Boolean set(String key, String value, Long time) {
        return redisService.set(key, value, time);
    }

    @DeleteMapping("/del")
    public void del(String... key) {
        redisService.del(key);
    }

    @GetMapping("/get")
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisService.getRedisTemplate();
    }
}
