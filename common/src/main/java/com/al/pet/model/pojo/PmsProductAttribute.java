package com.al.pet.model.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PmsProductAttribute {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long type;
    private Long parentId;
    private String name;
    private Integer sort;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

}
