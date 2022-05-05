package com.al.pet.service.impl;

import com.al.pet.mapper.SkuMapper;
import com.al.pet.mapper.SkuPicMapper;
import com.al.pet.model.pojo.PmsSku;
import com.al.pet.model.pojo.PmsSkuPic;
import com.al.pet.service.CartService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author al
 * @version 1.0
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private SkuPicMapper skuPicMapper;

    @Override
    public PmsSku getSku(Long id) {
        return skuMapper.selectById(id);
    }

    @Override
    public PmsSkuPic getSkuPic(Long skuId) {
        return skuPicMapper.selectList(new LambdaQueryWrapper<PmsSkuPic>()
                .eq(PmsSkuPic::getSkuId, skuId)).get(0);
    }
}
