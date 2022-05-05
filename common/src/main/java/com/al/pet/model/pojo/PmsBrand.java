package com.al.pet.model.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PmsBrand {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String firstLetter;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

}
