package com.al.pet.service;

/**
 * token业务类
 *
 * @author Al
 * @version 1.0
 **/
public interface TokenService {

    /**
     * 检查请求是否需要token验证
     *
     * @param path 请求路径
     * @return boolean
     */
    Boolean checkPath(String path);

    /**
     * 检查token是否是有效的
     *
     * @param token token
     * @return boolean
     */
    Boolean checkToken(String token);

    /**
     * 创建token
     *
     * @param id        token编号
     * @param subject   主题
     * @param ttlMillis 过期时间 负数表示不过期
     * @return token
     */
    String creat(String id, String subject, long ttlMillis);

    /**
     * 根据token获取id
     *
     * @param token token
     * @return id
     */
    String getId(String token);


}
