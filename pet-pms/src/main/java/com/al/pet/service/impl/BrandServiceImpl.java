package com.al.pet.service.impl;

import com.al.pet.mapper.BrandMapper;
import com.al.pet.model.pojo.PmsBrand;
import com.al.pet.model.vo.BrandVo;
import com.al.pet.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author al
 * @version 1.0
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<BrandVo> list() {
        return brandMapper.selectList(new LambdaQueryWrapper<PmsBrand>()
                        .orderByDesc(PmsBrand::getFirstLetter))
                .stream()
                .map(BrandVo::build)
                .collect(Collectors.toList());
    }
}
