package com.al.pet.model.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PmsProductDetailPic {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long spuId;
    private String picUrl;
    private Integer sort;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;


}
