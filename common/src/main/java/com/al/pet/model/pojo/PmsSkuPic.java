package com.al.pet.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PmsSkuPic {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long skuId;
    private String picUrl;
    private Integer isDefault;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;


}
