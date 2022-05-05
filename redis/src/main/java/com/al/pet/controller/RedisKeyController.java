package com.al.pet.controller;

import com.al.pet.service.RedisKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redisKey接口
 *
 * @author al
 * @version 1.0
 */
@RequestMapping("/key")
@RestController
public class RedisKeyController {

    @Autowired
    private RedisKeyService redisKeyService;

    @GetMapping("/get")
    public String get(String prefix, String... args) {
        return redisKeyService.getKey(prefix, (Object[]) args);
    }

    @GetMapping("/pms")
    public String pmsGet(Object... args) {
        return redisKeyService.getPmsKey(args);
    }

    @GetMapping("/oms")
    public String omsGet(Object... args) {
        return redisKeyService.getOmsKey(args);
    }

    @GetMapping("/ums")
    public String umsGet(String... args) {
        return redisKeyService.getUmsKey((Object[]) args);
    }
}
