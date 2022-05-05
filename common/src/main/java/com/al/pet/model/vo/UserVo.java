package com.al.pet.model.vo;

import lombok.Data;

/**
 * 用户
 *
 * @author al
 * @version 1.0
 */
@Data
public class UserVo {
    private Long id;
    private String account;
    private String openId;
    private String userName;

    public UserVo() {
    }

    public UserVo(String phone) {
        this.account = phone;
        this.userName = phone;
    }
}
