package com.al.pet.controller;

import com.al.pet.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信服务
 *
 * @author al
 * @version 1.0
 */
@RestController
@RequestMapping("/sms")
public class SmsController {
    @Autowired
    private SmsUtils smsUtils;

    @GetMapping("/send")
    public String send(String phone, Integer codeType) {
        return smsUtils.sendSms(phone, codeType);
    }
}
