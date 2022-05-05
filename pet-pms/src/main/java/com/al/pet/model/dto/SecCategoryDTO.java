package com.al.pet.model.dto;

import com.al.pet.model.pojo.PmsProductCategory;
import lombok.Data;

/**
 * 二级分类列表
 *
 * @author al
 * @version 1.0
 */
@Data
public class SecCategoryDTO {
    private Long secId;
    private String secName;
    private Integer secLevel;
    private Integer secShowStatus;
    private String secIcon;

    public static SecCategoryDTO build(PmsProductCategory category) {
        SecCategoryDTO dto = new SecCategoryDTO();
        dto.setSecId(category.getId());
        dto.setSecName(category.getName());
        dto.setSecLevel(category.getLevel());
        dto.setSecShowStatus(category.getShowStatus());
        dto.setSecIcon(category.getIcon());
        return dto;
    }
}
