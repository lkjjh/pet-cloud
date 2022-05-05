package com.al.pet.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 短信服务
 *
 * @author Al
 * @version 1.0
 **/
@Service
@FeignClient("aliyun-service")
public interface SmsService {
    /**
     * 根据手机号和验证码类型发送短信
     *
     * @param phone    手机号
     * @param codeType 验证码类型
     * @return 验证码
     */
    @GetMapping("/api/aliyun/sms/send")
    String send(@RequestParam("phone") String phone,
                @RequestParam("codeType") Integer codeType);
}
