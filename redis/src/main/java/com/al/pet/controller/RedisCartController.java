package com.al.pet.controller;

import com.al.pet.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 购物车缓存操作
 *
 * @author al
 * @version 1.0
 */
@RestController
@RequestMapping("/cart")
public class RedisCartController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/save")
    public void save(String key, String hashKey, String obj) {
        redisUtil.getRedisTemplate()
                .opsForHash()
                .put(key, hashKey, obj);
    }

    @GetMapping("/values/{key}")
    List values(@PathVariable String key) {
        return redisUtil.getRedisTemplate()
                .opsForHash()
                .values(key);
    }

    @GetMapping("/del")
    void del(String key, String[] keys) {
        redisUtil.getRedisTemplate()
                .opsForHash()
                .delete(key, (Object[]) keys);
    }
}
