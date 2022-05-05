package com.al.pet.controller;

import com.al.pet.enums.Code;
import com.al.pet.service.RedisKeyService;
import com.al.pet.service.RedisService;
import com.al.pet.service.SmsService;
import com.al.pet.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信接口
 *
 * @author al
 * @version 1.0
 */
@RestController
@RequestMapping("/sms")
public class SmsController {
    @Autowired
    private SmsService smsService;
    @Autowired
    private RedisKeyService redisKeyService;
    @Autowired
    private RedisService redisService;

    @PostMapping("/sendSms")
    public CommonResult<String> sendSms(String phone, Integer codeType) {
        String random = smsService.send(phone, codeType);
        if (random.isEmpty()) {
            return CommonResult.code(Code.FAILED_SEND_SMS);
        }
        String key = redisKeyService.umsGet(phone);
        System.out.println(key);
        long expire = redisService.getExpire(key);
        if (expire > 60L) {
            return CommonResult.code(Code.OPERATING_FREQUENCY);
        }
        redisService.set(key, random, 5 * 60L);
        System.out.println("验证码:" + random);
        return CommonResult.ok();
    }
}
