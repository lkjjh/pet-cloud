package com.al.pet.service;

import com.al.pet.model.vo.BrandVo;

import java.util.List;

/**
 * 商品品牌接口
 *
 * @author Al
 * @version 1.0
 **/
public interface BrandService {
    /**
     * 查询所有商品列表，按照字母排序
     *
     * @return
     */
    List<BrandVo> list();
}
