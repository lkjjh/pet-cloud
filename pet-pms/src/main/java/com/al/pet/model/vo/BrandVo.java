package com.al.pet.model.vo;

import com.al.pet.model.pojo.PmsBrand;
import lombok.Data;

/**
 * 描述
 *
 * @author al
 * @version 1.0
 */
@Data
public class BrandVo {
    private Long id;
    private String name;

    public static BrandVo build(PmsBrand brand) {
        BrandVo vo = new BrandVo();
        vo.setId(brand.getId());
        vo.setName(brand.getName());
        return vo;
    }
}
