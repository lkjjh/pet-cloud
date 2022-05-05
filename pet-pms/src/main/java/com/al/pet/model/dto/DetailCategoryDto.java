package com.al.pet.model.dto;

import com.al.pet.model.pojo.PmsProductCategory;
import lombok.Data;

/**
 * 商品详细分类
 *
 * @author al
 * @version 1.0
 */
@Data
public class DetailCategoryDto {
    private Long id;
    private String name;

    public static DetailCategoryDto build(PmsProductCategory category) {
        DetailCategoryDto dto = new DetailCategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}
