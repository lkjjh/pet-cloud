package com.al.pet.service;

/**
 * 生成缓存key
 *
 * @author Al
 * @version 1.0
 **/
public interface RedisKeyService {
    /**
     * 生成key
     *
     * @param prefix 业务前缀
     * @param args   参数
     * @return key
     */
    String getKey(String prefix, Object... args);

    /**
     * 生成商品业务key
     *
     * @param args 参数
     * @return key
     */
    String getPmsKey(Object... args);

    /**
     * 生成订单key
     *
     * @param args 参数
     * @return key
     */
    String getOmsKey(Object... args);

    /**
     * 生成用户key
     *
     * @param args 参数
     * @return key
     */
    String getUmsKey(Object... args);
}
