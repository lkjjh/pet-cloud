package com.al.pet.model.vo;

import com.al.pet.model.dto.DetailCategoryDto;
import com.al.pet.model.dto.DetailSpuDto;
import com.al.pet.model.dto.SkuDto;
import lombok.Data;

import java.util.List;

/**
 * 商品详细
 *
 * @author al
 * @version 1.0
 */
@Data
public class DetailVo {
    private DetailSpuDto spu;
    private List<DetailCategoryDto> categories;
    private List<SkuDto> skuList;

    public static DetailVo build(DetailSpuDto spu, List<SkuDto> skuList, List<DetailCategoryDto> categoryDtos) {
        DetailVo detailVo = new DetailVo();
        detailVo.setSpu(spu);
        detailVo.setCategories(categoryDtos);
        detailVo.setSkuList(skuList);
        return detailVo;
    }
}
