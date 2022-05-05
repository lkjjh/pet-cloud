package com.al.pet.model.dto;

import com.al.pet.model.pojo.PmsProductDetailPic;
import com.al.pet.util.Constants;
import lombok.Data;

/**
 * 商品详细图片
 *
 * @author al
 * @version 1.0
 */
@Data
public class ProductDetailPicDto {
    private Long picId;
    private String picUrl;

    public static ProductDetailPicDto build(PmsProductDetailPic detailPic) {
        ProductDetailPicDto dto = new ProductDetailPicDto();
        dto.setPicId(detailPic.getId());
        dto.setPicUrl(detailPic.getPicUrl());
        return dto;
    }

    public String getPicUrl() {
        return Constants.Address.ADDRESS + picUrl;
    }
}
