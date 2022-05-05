package com.al.pet.model.dto;

import com.al.pet.model.pojo.PmsSkuPic;
import com.al.pet.util.Constants;
import lombok.Data;

/**
 * @author al
 * @version 1.0
 */
@Data
public class SkuPicDto {
    private Long id;
    private Long skuId;
    private String picUrl;
    private Integer isDefault;

    public static SkuPicDto build(PmsSkuPic pic) {
        SkuPicDto dto = new SkuPicDto();
        dto.setId(pic.getId());
        dto.setSkuId(pic.getSkuId());
        dto.setPicUrl(pic.getPicUrl());
        dto.setIsDefault(pic.getIsDefault());
        return dto;
    }

    public String getPicUrl() {
        return Constants.Address.ADDRESS + picUrl;
    }
}
