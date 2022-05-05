package com.al.pet.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 操作redis
 *
 * @author Al
 * @version 1.0
 **/
@Service
@FeignClient(value = "${service.redis.name}")
public interface RedisService {

    /**
     * 获取缓存
     *
     * @param key key
     * @return 值
     */
    @GetMapping("/api/redis/{key}")
    Object get(@PathVariable(value = "key") String key);
}
