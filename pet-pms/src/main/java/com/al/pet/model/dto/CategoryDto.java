package com.al.pet.model.dto;

import com.al.pet.model.pojo.PmsProductCategory;
import lombok.Data;

import java.util.List;

/**
 * 一级分类列表
 *
 * @author al
 * @version 1.0
 */
@Data
public class CategoryDto {

    private Long id;
    private String name;
    private String abbreviation;
    private Integer level;
    private Integer showStatus;
    private String icon;
    private List<SecCategoryDTO> secProductCategoryList;

    public static CategoryDto build(PmsProductCategory category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setAbbreviation(category.getAbbreviation());
        dto.setLevel(category.getLevel());
        dto.setShowStatus(category.getShowStatus());
        dto.setIcon(dto.getIcon());
        return dto;
    }

}
