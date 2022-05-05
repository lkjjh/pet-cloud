package com.al.pet.service;

import com.al.pet.model.pojo.PmsSku;
import com.al.pet.model.pojo.PmsSkuPic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 购物车服务
 *
 * @author Al
 * @version 1.0
 **/
@FeignClient("${service.pms.name}")
@Service
public interface PmsCartService {
    /**
     * 根据id获取商品规格
     *
     * @param id 规格id
     * @return
     */
    @GetMapping("/api/pms/cart/sku/{id}")
    PmsSku getSku(@PathVariable("id") Long id);

    /**
     * 根据规格id获取规格图片
     *
     * @param skuId 规格id
     * @return
     */
    @GetMapping("/api/pms/cart/skuPic/{skuId}")
    PmsSkuPic getSkuPic(@PathVariable("skuId") Long skuId);
}
