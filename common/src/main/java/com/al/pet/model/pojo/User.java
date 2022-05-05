package com.al.pet.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表
 */
@Data
@TableName(value = "ums_user")
public class User implements Serializable {
    public static final String COL_ID = "id";
    public static final String COL_ACCOUNT = "account";
    public static final String COL_OPENID = "openId";
    public static final String COL_USER_NAME = "user_name";
    public static final String COL_HEAD_URL = "head_url";
    public static final String COL_SEX = "sex";
    public static final String COL_PASSWORD = "password";
    public static final String COL_CREATED_TIME = "created_time";
    public static final String COL_UPDATED_TIME = "updated_time";
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;
    /**
     * 微信openId
     */
    @TableField(value = "openId")
    private String openid;
    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 用户头像URL
     */
    @TableField(value = "head_url")
    private String headUrl;
    /**
     * 性别 0->保密，1->男性，2->女性
     */
    @TableField(value = "sex")
    private Byte sex;
    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;
    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private LocalDateTime createdTime;
    /**
     * 修改时间
     */
    @TableField(value = "updated_time")
    private LocalDateTime updatedTime;
}