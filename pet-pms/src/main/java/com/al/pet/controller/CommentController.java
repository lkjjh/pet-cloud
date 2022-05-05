package com.al.pet.controller;

import com.al.pet.model.condition.CommentCondition;
import com.al.pet.model.condition.SaveCommentCondition;
import com.al.pet.model.dto.CommentDto;
import com.al.pet.service.CommentService;
import com.al.pet.util.CommonResult;
import com.al.pet.util.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 评论接口
 *
 * @author al
 * @version 1.0
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService service;

    @GetMapping("/commentList")
    public CommonResult<Page<CommentDto>> commentList(CommentCondition condition) {
        Page<CommentDto> page = service.commentList(condition);
        return Objects.isNull(page.getList())
                ? CommonResult.nullData()
                : CommonResult.ok(page);
    }

    @PostMapping("/postComment")
    public CommonResult<String> saveComment(SaveCommentCondition condition, @RequestHeader("token") String token) throws JsonProcessingException {
        service.saveComment(condition, token);
        return CommonResult.ok();
    }
}
