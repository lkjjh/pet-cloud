package com.al.pet.model.dto;

import com.al.pet.model.pojo.PmsProductAttribute;
import lombok.Data;

/**
 * @author al
 * @version 1.0
 */
@Data
public class AttributeValueDTO {
    private Long valueId;
    private String valueName;

    public static AttributeValueDTO build(PmsProductAttribute attribute) {
        AttributeValueDTO dto = new AttributeValueDTO();
        dto.setValueId(attribute.getId());
        dto.setValueName(attribute.getName());
        return dto;
    }
}
