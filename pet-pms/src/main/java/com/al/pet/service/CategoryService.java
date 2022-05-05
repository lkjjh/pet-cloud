package com.al.pet.service;

import com.al.pet.model.dto.CategoryDto;
import com.al.pet.model.dto.DetailCategoryDto;

import java.util.List;

/**
 * 商品分类业务
 *
 * @author Al
 * @version 1.0
 **/
public interface CategoryService {

    /**
     * 获取所有商品分类及其子分类
     *
     * @return
     */
    List<CategoryDto> list();

    /**
     * 根据id查询分类
     *
     * @param id
     * @return
     */
    DetailCategoryDto get(Long id);
}
