package com.al.pet.controller;

import com.al.pet.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证token
 *
 * @author al
 * @version 1.0
 */
@RestController
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @GetMapping("/checkPath/{path}")
    public Boolean checkPath(@PathVariable String path) {
        return tokenService.checkPath(path);
    }

    @GetMapping("/checkToken/{token}")
    public Boolean checkToken(@PathVariable String token) {
        return tokenService.checkToken(token);
    }

    @GetMapping("/creat")
    public String creat(String id, String subject, Long ttlMillis) {
        return tokenService.creat(id, subject, ttlMillis);
    }

    @GetMapping("/getId")
    public String getId(String token) {
        return tokenService.getId(token);
    }


}
