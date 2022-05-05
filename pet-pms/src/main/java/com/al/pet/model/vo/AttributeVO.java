package com.al.pet.model.vo;

import com.al.pet.model.dto.AttributeValueDTO;
import com.al.pet.model.pojo.PmsProductAttribute;
import lombok.Data;

import java.util.List;

/**
 * @author al
 * @version 1.0
 */
@Data
public class AttributeVO {

    private Long keyId;
    private String keyName;
    private List<AttributeValueDTO> productAttributeValueDtoList;

    public static AttributeVO build(PmsProductAttribute attribute) {
        AttributeVO vo = new AttributeVO();
        vo.setKeyId(attribute.getId());
        vo.setKeyName(attribute.getName());
        return vo;
    }
}
