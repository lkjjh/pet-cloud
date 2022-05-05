package com.al.pet.service;

import com.al.pet.model.condition.SearchCondition;
import com.al.pet.model.vo.DetailVo;
import com.al.pet.model.vo.SearchVo;

/**
 * 商品业务
 *
 * @author Al
 * @version 1.0
 **/
public interface ProductService {
    /**
     * 商品搜索
     *
     * @param condition 搜索条件
     * @return 搜索商品
     */
    SearchVo search(SearchCondition condition);

    /**
     * 根据商品id查询商品详细
     *
     * @param spuId 商品id
     * @return
     */
    DetailVo detail(Long spuId);
}
