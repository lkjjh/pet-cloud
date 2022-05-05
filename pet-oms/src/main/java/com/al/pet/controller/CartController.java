package com.al.pet.controller;

import com.al.pet.service.CartService;
import com.al.pet.util.CommonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 购物车接口
 *
 * @author al
 * @version 1.0
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CommonResult<String> add(Long skuId, Integer num, @RequestHeader("token") String token) throws JsonProcessingException {
        cartService.save(skuId, num, token);
        return CommonResult.ok();
    }

    @GetMapping("/cartList")
    public CommonResult<List<Object>> list(@RequestHeader("token") String token) throws JsonProcessingException {
        List<Object> list = cartService.list(token);
        return CommonResult.ok(list);
    }

    @PostMapping("/remove")
    public CommonResult<String> remove(@RequestHeader("token") String token,
                                       String[] skuIds) throws JsonProcessingException {
        cartService.remove(token, skuIds);
        return CommonResult.ok();
    }
}
