package com.al.pet.model.pojo;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PmsProductCategoryAttributeRel {

    private Long id;
    private Long productCategoryId;
    private Long productAttributeId;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

}
