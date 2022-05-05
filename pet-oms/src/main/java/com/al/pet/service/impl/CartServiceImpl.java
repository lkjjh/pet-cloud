package com.al.pet.service.impl;

import com.al.pet.model.dto.CartDTO;
import com.al.pet.model.pojo.PmsSku;
import com.al.pet.model.pojo.PmsSkuPic;
import com.al.pet.model.pojo.User;
import com.al.pet.service.*;
import com.al.pet.util.Constants;
import com.al.pet.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author al
 * @version 1.0
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private RedisKeyService redisKeyService;
    @Autowired
    private RedisCartService redisCartService;
    @Autowired
    private UserService userService;
    @Autowired
    private JsonUtils jsonUtils;
    @Autowired
    private PmsCartService pmsCartService;
    @Autowired
    private Constants.System system;

    @Override
    public void save(Long skuId, Integer num, String token) {
        User user = userService.parseToken(token).getData();
        PmsSku sku = pmsCartService.getSku(skuId);
        CartDTO cartDTO = CartDTO.build(sku);
        cartDTO.setNum(num);
        cartDTO.setUserId(user.getId());
        PmsSkuPic pic = pmsCartService.getSkuPic(skuId);
        cartDTO.setPicUrl(pic.getPicUrl());
        String key = getKey(user.getId());
        try {
            redisCartService.save(key, skuId.toString(), jsonUtils.get(cartDTO));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Object> list(String token) {
        String key = getKey(token);
        return redisCartService.values(key)
                .stream()
                .map(s -> jsonUtils.get(s, CartDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(String token, String... skuIds) {
        String key = getKey(token);
        redisCartService.del(key, skuIds);
    }

    private String getKey(Long userId) {
        return redisKeyService.get(system.getCart(), userId);
    }

    private String getKey(String token) {
        User user = userService.parseToken(token).getData();
        return getKey(user.getId());
    }
}
