package com.al.pet.service.impl;

import com.al.pet.service.RedisService;
import com.al.pet.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author al
 * @version 1.0
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Object get(String key) {
        return redisUtil.get(key);
    }

    @Override
    public Long getExpire(String key) {
        return redisUtil.getExpire(key);
    }

    @Override
    public boolean set(String key, Object value) {
        return redisUtil.set(key, value);
    }

    @Override
    public boolean set(String key, Object value, Long time) {
        return redisUtil.set(key, value, time);
    }

    @Override
    public void del(String... key) {
        redisUtil.del(key);
    }

    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisUtil.getRedisTemplate();
    }
}
