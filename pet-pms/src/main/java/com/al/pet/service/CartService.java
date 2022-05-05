package com.al.pet.service;

import com.al.pet.model.pojo.PmsSku;
import com.al.pet.model.pojo.PmsSkuPic;

/**
 * 购物车服务
 *
 * @author Al
 * @version 1.0
 **/
public interface CartService {
    /**
     * 根据id获取商品规格
     *
     * @param id 规格id
     * @return
     */
    PmsSku getSku(Long id);

    /**
     * 根据规格id获取规格图片
     *
     * @param skuId 规格id
     * @return
     */
    PmsSkuPic getSkuPic(Long skuId);
}
