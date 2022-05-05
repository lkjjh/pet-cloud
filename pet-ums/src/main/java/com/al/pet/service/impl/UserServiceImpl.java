package com.al.pet.service.impl;

import com.al.pet.enums.Code;
import com.al.pet.mapper.UserMapper;
import com.al.pet.model.pojo.User;
import com.al.pet.service.RedisKeyService;
import com.al.pet.service.RedisService;
import com.al.pet.service.TokenService;
import com.al.pet.service.UserService;
import com.al.pet.util.CommonResult;
import com.al.pet.util.JsonUtils;
import com.al.pet.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author al
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JsonUtils jsonUtils;
    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisKeyService redisKeyService;
    @Autowired
    private TokenService tokenService;

    @Override
    public CommonResult<Map<String, String>> login(String phone, String sms) throws JsonProcessingException {
        String key = redisKeyService.umsGet(phone);
        Map<String, String> map = new HashMap<>(1);
        if (!Objects.equals(sms, jsonUtils.get(redisService.get(key), String.class))) {
            return CommonResult.code(Code.SMS_IS_INCORRECT);
        }
        CommonResult<Map<String, String>> res = CommonResult.code(Code.OK);
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(StringUtils.notNull(phone), User::getAccount, phone));
        String tokenKey = redisKeyService.umsGet("token", phone);
        if (Objects.isNull(user)) {
            user = new User();
            user.setAccount(phone);
            user.setUserName(phone);
            userMapper.insert(user);
        }
        String json = jsonUtils.get(user);
        String token = tokenService.creat(phone, json, -1L);
        redisService.set(tokenKey, token, -1L);
        map.put("token", token);
        res.setData(map);
        return res;
    }

    @Override
    public User get(String token) {
//        if (!tokenService.checkToken(token)) {
//            return null;
//        }
        String phone = tokenService.getId(token);
        System.out.println(phone);
        return userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(StringUtils.notNull(phone), User::getAccount, phone));

    }

    @Override
    public void del(String token) {
        String phone = tokenService.getId(token);
        String tokenKey = redisKeyService.umsGet("token", phone);
        redisService.del(tokenKey);
    }

    @Override
    public User getId(Long id) {
        return userMapper.selectById(id);
    }
}
