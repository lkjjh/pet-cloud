package com.al.pet.model.dto;

import com.al.pet.model.pojo.PmsComment;
import com.al.pet.model.pojo.User;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author al
 * @version 1.0
 */
@Data
public class CommentDto {
    private Long commentId;
    private Long spuId;
    private Long userId;
    private Long star;
    private String content;
    private Integer isPic;
    private LocalDateTime addTime;
    private String imgList;
    private String userName;
    private String headUrl;

    public static CommentDto build(PmsComment comment, User user) {
        CommentDto dto = new CommentDto();
        dto.setCommentId(comment.getId());
        dto.setSpuId(comment.getSpuId());
        dto.setStar(comment.getStar());
        dto.setContent(comment.getContent());
        dto.setIsPic(comment.getIsPic());
        dto.setAddTime(comment.getCreatedTime());
        if (user != null) {
            dto.setHeadUrl(user.getHeadUrl());
            dto.setUserId(user.getId());
            dto.setUserName(user.getUserName());
        }
        return dto;
    }
}
