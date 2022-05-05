package com.al.pet.model.dto;

import com.al.pet.model.pojo.PmsProductDetailPic;
import com.al.pet.model.pojo.Spu;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author al
 * @version 1.0
 */
@Data
public class DetailSpuDto {
    private Long id;
    private Long brandId;
    private Long cid1;
    private Long cid2;
    private String name;
    private String subTitle;
    private Integer sale;
    private Integer commentAmount;
    private Integer commentTotalScore;
    private String productSpecification;
    private BigDecimal defaultPrice;
    private String defaultPicUrl;
    private Integer publishStatus;
    private Byte verifyStatus;
    private Integer valid;
    private List<ProductDetailPicDto> productDetailPicList;

    public static DetailSpuDto build(Spu spu, List<PmsProductDetailPic> pics) {
        List<ProductDetailPicDto> list = pics.stream()
                .map(ProductDetailPicDto::build)
                .collect(Collectors.toList());
        DetailSpuDto dto = new DetailSpuDto();
        dto.setProductDetailPicList(list);
        dto.setId(spu.getId());
        dto.setBrandId(spu.getBrandId());
        dto.setCid1(spu.getCid1());
        dto.setCid2(spu.getCid2());
        dto.setName(spu.getName());
        dto.setSubTitle(spu.getSubTitle());
        dto.setSale(spu.getSale());
        dto.setCommentAmount(spu.getCommentAmount());
        dto.setCommentTotalScore(spu.getCommentTotalScore());
        dto.setProductSpecification(spu.getProductSpecification());
        dto.setDefaultPicUrl(spu.getDefaultPicUrl());
        dto.setPublishStatus(spu.getPublishStatus() ? 1 : 0);
        dto.setVerifyStatus(spu.getVerifyStatus());
        dto.setValid(spu.getValid() ? 1 : 0);
        return dto;
    }
}
