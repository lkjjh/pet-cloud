package com.al.pet.controller;

import com.al.pet.model.pojo.User;
import com.al.pet.service.UserService;
import com.al.pet.util.CommonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * 用户接口
 *
 * @author al
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/login")
    public CommonResult<Map<String, String>> login(String phone, String sms) throws JsonProcessingException {
        return service.login(phone, sms);
    }

    @GetMapping("/getUserByToken")
    public CommonResult<User> parseToken(@RequestHeader("token") String token) {
        User vo = service.get(token);
        return Objects.isNull(vo)
                ? CommonResult.nullData()
                : CommonResult.ok(vo);
    }

    @GetMapping("/logout")
    public CommonResult<String> logout(@RequestHeader("token") String token) throws JsonProcessingException {
        service.del(token);
        return CommonResult.ok();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.getId(id);
    }
}
