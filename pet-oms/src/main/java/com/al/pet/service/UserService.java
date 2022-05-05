package com.al.pet.service;

import com.al.pet.model.pojo.User;
import com.al.pet.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * ums服务
 *
 * @author Al
 * @version 1.0
 **/
@FeignClient("${service.ums.name}")
@Service
public interface UserService {
    /**
     * 根据id获取用户信息
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/api/ums/user/{id}")
    User getId(@PathVariable("id") Long id);

    /**
     * 根据token获取用户信息
     *
     * @param token token
     * @return 用户
     */
    @GetMapping("/api/ums/user/getUserByToken")
    CommonResult<User> parseToken(@RequestHeader("token") String token);
}
