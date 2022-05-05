package com.al.pet.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * token业务类
 *
 * @author Al
 * @version 1.0
 **/
@Service
@FeignClient("${service.authentication.name}")
public interface TokenService {
    /**
     * 检查请求是否需要token验证
     *
     * @param path 请求路径
     * @return boolean
     */
    @GetMapping("/api/authentication/checkPath/{path}")
    Boolean checkPath(@PathVariable("path") String path);

    /**
     * 检查token是否是有效的
     *
     * @param token token
     * @return boolean
     */
    @GetMapping("/api/authentication/checkToken/{token}")
    Boolean checkToken(@PathVariable("token") String token);

    /**
     * 创建token
     *
     * @param id        token编号
     * @param subject   主题
     * @param ttlMillis 过期时间 负数表示不过期
     * @return token
     */
    @GetMapping("/api/authentication/creat")
    String creat(@RequestParam("id") String id, @RequestParam("subject") String subject,
                 @RequestParam("ttlMillis") Long ttlMillis);

    /**
     * 根据token获取id
     *
     * @param token token
     * @return id
     */
    @GetMapping("/api/authentication/getId")
    String getId(@RequestParam("token") String token);
}
