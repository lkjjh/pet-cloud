package com.al.pet.service.impl;

import com.al.pet.service.RedisKeyService;
import com.al.pet.service.RedisService;
import com.al.pet.service.TokenService;
import com.al.pet.util.Constants;
import com.al.pet.util.StringUtils;
import com.al.pet.util.TokenUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author al
 * @version 1.0
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private Constants.GatWay gatWay;
    @Autowired
    private RedisKeyService redisKeyService;
    @Autowired
    private RedisService redisService;

    @Override
    public Boolean checkPath(String path) {
        if (StringUtils.isNull(path)) {
            return false;
        }
        return gatWay.getPathList().contains(path);
    }

    @Override
    public Boolean checkToken(String token) {
        if (StringUtils.isNull(token)) {
            return false;
        }
        Claims jwt = tokenUtils.parseJWT(token);
        String phone = jwt.getId();
        String key = redisKeyService.umsGet("token", phone);
        return Objects.equals(token, redisService.get(key));
    }

    @Override
    public String creat(String id, String subject, long ttlMillis) {
        return tokenUtils.createJWT(id, subject, ttlMillis);
    }

    @Override
    public String getId(String token) {
        return tokenUtils.parseJWT(token).getId();
    }
}
