package com.al.pet.model.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PmsSku {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long spuId;
    private String title;
    private BigDecimal price;
    private String unit;
    private Integer stock;
    private Integer sale;
    private String indexes;
    private String productSkuSpecification;
    private Integer isDefault;
    private Integer valid;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

}
