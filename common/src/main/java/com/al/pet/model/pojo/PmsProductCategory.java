package com.al.pet.model.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PmsProductCategory {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long parentId;
    private String name;
    private String abbreviation;
    private Integer level;
    private Integer showStatus;
    private String icon;
    private Integer sort;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

}
