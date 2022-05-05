package com.al.pet.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 调用redisKey
 *
 * @author Al
 * @version 1.0
 **/
@FeignClient(value = "${service.redis.name}")
@Service
public interface RedisKeyService {
    /**
     * 生成key
     *
     * @param prefix 业务前缀
     * @param args   参数
     * @return key
     */
    @GetMapping("/api/redis/key/get")
    String get(@RequestParam("prefix") String prefix, @RequestParam("args") Object... args);

    /**
     * 生成商品业务key
     *
     * @param args 参数
     * @return key
     */
    @GetMapping("/api/redis/key/pms")
    String pmsGet(@RequestParam("args") Object... args);

    /**
     * 生成用户key
     *
     * @param args 参数
     * @return key
     */
    @GetMapping("/api/redis/key/ums")
    String umsGet(@RequestParam("args") Object... args);

    /**
     * 生成订单key
     *
     * @param args 参数
     * @return key
     */
    @GetMapping("/api/redis/key/oms")
    String omsGet(@RequestParam("args") Object... args);
}
