package com.al.pet.model.pojo;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PmsCommentPic {

    private Long id;
    private Long commentId;
    private String picUrl;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

}
