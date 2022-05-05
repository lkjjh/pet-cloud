package com.al.pet.service.impl;

import com.al.pet.mapper.ProductAttributeMapper;
import com.al.pet.mapper.ProductCategoryAttributeRelMapper;
import com.al.pet.model.dto.AttributeValueDTO;
import com.al.pet.model.pojo.PmsProductAttribute;
import com.al.pet.model.pojo.PmsProductCategoryAttributeRel;
import com.al.pet.model.vo.AttributeVO;
import com.al.pet.service.AttributeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author al
 * @version 1.0
 */
@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    private ProductAttributeMapper productAttributeMapper;
    @Autowired
    private ProductCategoryAttributeRelMapper productCategoryAttributeRelMapper;

    @Override
    public List<AttributeVO> byCategoryIds(Long... secIds) {
        List<Long> ids = productCategoryAttributeRelMapper.selectList(new LambdaQueryWrapper
                        <PmsProductCategoryAttributeRel>()
                        .in(Objects.nonNull(secIds) && secIds.length > 0, PmsProductCategoryAttributeRel::getProductCategoryId, (Object[]) secIds))
                .stream()
                .map(PmsProductCategoryAttributeRel::getProductAttributeId)
                .collect(Collectors.toList());
        List<PmsProductAttribute> list = productAttributeMapper.selectBatchIds(ids);
        return get(list);
    }

    @Override
    public List<AttributeVO> list() {
        List<PmsProductAttribute> list = productAttributeMapper.selectList(null);
        return get(list, 0L);
    }

    private List<AttributeVO> get(List<PmsProductAttribute> list) {
        return list.stream()
                .map(a -> {
                    AttributeVO vo = AttributeVO.build(a);
                    vo.setProductAttributeValueDtoList(list.stream()
                            .filter(a1 -> a1.getParentId().equals(a.getId()))
                            .map(AttributeValueDTO::build)
                            .collect(Collectors.toList()));
                    return vo;
                })
                .collect(Collectors.toList());
    }

    private List<AttributeVO> get(List<PmsProductAttribute> list, Long id) {
        return get(list.stream()
                .filter(a -> a.getParentId().equals(id))
                .collect(Collectors.toList()));
    }
}
