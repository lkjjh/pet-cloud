package com.al.pet.service;

import com.al.pet.model.condition.CommentCondition;
import com.al.pet.model.condition.SaveCommentCondition;
import com.al.pet.model.dto.CommentDto;
import com.al.pet.util.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 评论业务
 *
 * @author Al
 * @version 1.0
 **/
public interface CommentService {
    /**
     * 根据条件获取评论列表
     *
     * @param condition 条件
     * @return
     */
    Page<CommentDto> commentList(CommentCondition condition);

    /**
     * 新增评论
     *
     * @param condition 条件
     * @param token     token
     */
    @Transactional(rollbackFor = Exception.class)
    void saveComment(SaveCommentCondition condition, String token) throws JsonProcessingException;
}
