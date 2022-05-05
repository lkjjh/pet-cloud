package com.al.pet.model.dto;

import com.al.pet.model.pojo.PmsSku;
import com.al.pet.model.pojo.Spu;
import com.al.pet.util.Constants;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author al
 * @version 1.0
 */
@Data
public class SkuDto {

    private Long id;
    private Long spuId;
    private String title;
    private BigDecimal price;
    private String unit;
    private Integer stock;
    private Integer publishStatus;
    private String picUrl;
    private Integer sale;
    private String indexes;
    private String productSkuSpecification;
    private Integer isDefault;
    private Integer valid;
    private List<SkuPicDto> skuPicList;

    public static SkuDto build(Spu spu, PmsSku sku) {
        SkuDto skuDto = new SkuDto();
        skuDto.setId(sku.getId());
        skuDto.setSpuId(spu.getId());
        skuDto.setTitle(sku.getTitle());
        skuDto.setPrice(sku.getPrice());
        skuDto.setUnit(sku.getUnit());
        skuDto.setStock(sku.getStock());
        skuDto.setPublishStatus(spu.getPublishStatus() ? 1 : 0);
        skuDto.setPicUrl(spu.getDefaultPicUrl());
        skuDto.setSale(spu.getSale());
        skuDto.setIndexes(sku.getIndexes());
        skuDto.setProductSkuSpecification(sku.getProductSkuSpecification());
        skuDto.setIsDefault(sku.getIsDefault());
        skuDto.setValid(sku.getValid());
        return skuDto;
    }

    public String getPicUrl() {
        return Constants.Address.ADDRESS + picUrl;
    }
}
