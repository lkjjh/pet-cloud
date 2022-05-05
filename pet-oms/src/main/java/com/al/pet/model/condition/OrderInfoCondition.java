package com.al.pet.model.condition;

import lombok.Data;

import java.util.List;

/**
 * @author al
 * @version 1.0
 */
@Data
public class OrderInfoCondition {
    private List<SkuInfo> skuInfos;
    private Long userId;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
}
