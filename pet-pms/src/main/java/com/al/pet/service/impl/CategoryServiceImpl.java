package com.al.pet.service.impl;

import com.al.pet.mapper.ProductCategoryMapper;
import com.al.pet.model.dto.CategoryDto;
import com.al.pet.model.dto.DetailCategoryDto;
import com.al.pet.model.dto.SecCategoryDTO;
import com.al.pet.model.pojo.PmsProductCategory;
import com.al.pet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author al
 * @version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<CategoryDto> list() {
        List<PmsProductCategory> list = productCategoryMapper.selectList(null);
        return list.stream()
                .filter(c -> c.getParentId().equals(0L))
                .map(c -> {
                    CategoryDto dto = CategoryDto.build(c);
                    dto.setSecProductCategoryList(list.stream()
                            .filter(c1 -> c1.getParentId().equals(c.getId()))
                            .map(SecCategoryDTO::build)
                            .collect(Collectors.toList()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public DetailCategoryDto get(Long id) {
        return DetailCategoryDto.build(productCategoryMapper.selectById(id));
    }
}
