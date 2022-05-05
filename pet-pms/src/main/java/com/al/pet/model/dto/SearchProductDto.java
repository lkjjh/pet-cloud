package com.al.pet.model.dto;

import com.al.pet.model.pojo.Spu;
import com.al.pet.util.Constants;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品搜索dto
 *
 * @author al
 * @version 1.0
 */
@Data
public class SearchProductDto {
    private Long id;
    private String name;
    private Long sale;
    private String defaultPicUrl;
    private BigDecimal defaultPrice;

    public static SearchProductDto build(Spu spu) {
        SearchProductDto dto = new SearchProductDto();
        dto.setId(spu.getId());
        dto.setName(spu.getName());
        dto.setDefaultPicUrl(spu.getDefaultPicUrl());
        dto.setDefaultPrice(spu.getDefaultPrice());
        dto.setSale(Long.valueOf(spu.getSale()));
        return dto;
    }

    public String getDefaultPicUrl() {
        return Constants.Address.ADDRESS + defaultPicUrl;
    }
}
