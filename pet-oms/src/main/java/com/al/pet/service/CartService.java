package com.al.pet.service;

import java.util.List;

/**
 * 购物车业务
 *
 * @author Al
 * @version 1.0
 **/
public interface CartService {

    /**
     * 添加购物车
     *
     * @param skuId 商品规格id
     * @param num   商品数量
     * @param token 用户信息
     */
    void save(Long skuId, Integer num, String token);

    /**
     * 查询购物车列表
     *
     * @param token 用户信息
     * @return
     */
    List<Object> list(String token);

    /**
     * 移除购物车
     *
     * @param token  用户信息
     * @param skuIds 商品
     */
    void remove(String token, String... skuIds);
}
