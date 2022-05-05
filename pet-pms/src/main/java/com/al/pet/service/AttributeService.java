package com.al.pet.service;

import com.al.pet.model.vo.AttributeVO;

import java.util.List;

public interface AttributeService {
    /**
     * 根据商品二级分类ID查询商品属性列表
     *
     * @param secIds 二级分类集合
     * @return
     */
    List<AttributeVO> byCategoryIds(Long... secIds);

    /**
     * 查询所有商品属性
     *
     * @return
     */
    List<AttributeVO> list();
}
