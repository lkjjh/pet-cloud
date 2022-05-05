package com.al.pet.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
    String get(@PathVariable("key") String key);

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    @GetMapping("/api/redis/expire/{key}")
    Long getExpire(@PathVariable(value = "key") String key);

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    @PostMapping("/api/redis/{key}")
    Boolean set(@PathVariable("key") String key, @RequestBody @RequestParam("value") Object value);

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    @GetMapping("/api/redis/set")
    Boolean set(@RequestParam("key") String key, @RequestParam("value") Object value, @RequestParam("time") Long time);

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    @DeleteMapping("/api/redis/del")
    void del(@RequestParam("key") String... key);
}
