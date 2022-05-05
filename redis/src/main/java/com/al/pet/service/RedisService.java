package com.al.pet.service;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * 操作缓存
 *
 * @author Al
 * @version 1.0
 **/
public interface RedisService {
    /**
     * 获取缓存
     *
     * @param key key
     * @return 值
     */
    Object get(String key);

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    Long getExpire(String key);

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    boolean set(String key, Object value);

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    boolean set(String key, Object value, Long time);

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    void del(String... key);

    /**
     * 获取redis原生对象
     *
     * @return 操作对象
     */
    RedisTemplate<String, Object> getRedisTemplate();

}
