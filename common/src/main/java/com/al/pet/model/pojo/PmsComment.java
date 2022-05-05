package com.al.pet.model.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PmsComment {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long spuId;
    private Long userId;
    private Long star;
    private String content;
    private Integer isPic;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

}
