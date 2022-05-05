package com.al.pet.service.impl;

import com.al.pet.mapper.CommentMapper;
import com.al.pet.mapper.CommentPicMapper;
import com.al.pet.model.condition.CommentCondition;
import com.al.pet.model.condition.SaveCommentCondition;
import com.al.pet.model.dto.CommentDto;
import com.al.pet.model.pojo.PmsComment;
import com.al.pet.service.CommentService;
import com.al.pet.service.UserService;
import com.al.pet.util.Page;
import com.al.pet.util.StringUtils;
import com.alibaba.nacos.common.utils.Objects;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author al
 * @version 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentPicMapper commentPicMapper;
    @Autowired
    private UserService userService;

    @Override
    public Page<CommentDto> commentList(CommentCondition condition) {
        LambdaQueryWrapper<PmsComment> wrapper = new LambdaQueryWrapper<PmsComment>()
                .eq(Objects.nonNull(condition.getSpuId()), PmsComment::getSpuId, condition.getSpuId())
                .eq(Objects.nonNull(condition.getStar()), PmsComment::getStar, condition.getStar())
                .eq(StringUtils.notNull(condition.getContent()), PmsComment::getContent, condition.getContent())
                .eq(Objects.nonNull(condition.getIsPic()), PmsComment::getIsPic, condition.getIsPic());
        List<CommentDto> list = commentMapper.selectList(wrapper)
                .stream()
                .map(c -> CommentDto.build(c, userService.getId(c.getUserId())))
                .collect(Collectors.toList());
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PmsComment> page = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(condition.getPageNo(), condition.getPageSize());
        commentMapper.selectPage(page, wrapper);
        Page<CommentDto> page1 = new Page<>();
        page1.setPageNo(page.getCurrent());
        page1.setPageSize(page1.getPageSize());
        page1.setTotal(page1.getTotal());
        page1.setBeginPos(page.getCurrent());
        page1.setList(list);
        return page1;
    }

    @Override
    public void saveComment(SaveCommentCondition condition, String token) throws JsonProcessingException {

    }
}
