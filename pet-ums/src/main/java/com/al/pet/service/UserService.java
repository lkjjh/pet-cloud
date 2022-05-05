package com.al.pet.service;

import com.al.pet.model.pojo.User;
import com.al.pet.util.CommonResult;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

/**
 * 用户接口
 *
 * @author Al
 * @version 1.0
 **/
public interface UserService {
    /**
     * 用户登录 如果是第一次登录则注册
     *
     * @param phone 手机号
     * @param sms   验证码
     * @return token
     * @throws JsonProcessingException 字符串解析异常
     */
    CommonResult<Map<String, String>> login(String phone, String sms) throws JsonProcessingException;

    /**
     * 根据token获取用户信息
     *
     * @param token token
     * @return 用户
     */
    User get(String token);

    /**
     * 删除token
     *
     * @param token
     */
    void del(String token);

    /**
     * 根据id获取
     *
     * @param id 用户编号
     * @return 用户
     */
    User getId(Long id);
}
