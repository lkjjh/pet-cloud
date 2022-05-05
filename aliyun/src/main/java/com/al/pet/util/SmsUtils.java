package com.al.pet.util;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 描述
 *
 * @author al
 * @version 1.0
 */
@Component
public class SmsUtils {

//    @Resource
//    private AliYun.Sms aliYun;

    public String random;

    public String random(Integer codeType) {
        if (codeType.equals(1)) {
            return String.valueOf(new Random().nextInt(1000000) + 100000);
        }
        throw new IllegalArgumentException("验证码类型格式错误");
    }

    public String sendSms(String phone, Integer codeType) {
        random = random(codeType);
//        SendSmsResponse response = client().sendSms(createRequest(phone, random));
//        return "OK".equals(response.getBody().code);
        return random;
    }

//    public Client client() throws Exception {
//        Config config = new Config()
//                .setAccessKeyId(aliYun.get().getAccessKeyId())
//                .setAccessKeySecret(aliYun.get().getAccessKeySecret())
//                .setEndpoint(aliYun.getEndpoint());
//        return new Client(config);
//    }
//
//    public SendSmsRequest createRequest(String phone, String random) {
//        return new SendSmsRequest()
//                .setTemplateCode(aliYun.getTemplateCode())
//                .setSignName(aliYun.getSignName())
//                .setPhoneNumbers(phone)
//                .setTemplateParam("{\"code\":\""+ random +"\"}");
//    }

}
