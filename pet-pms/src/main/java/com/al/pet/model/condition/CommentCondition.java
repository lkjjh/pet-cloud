package com.al.pet.model.condition;

import com.al.pet.util.PageCondition;
import lombok.Data;

/**
 * @author al
 * @version 1.0
 */
@Data
public class CommentCondition extends PageCondition {
    private Long spuId;
    private Integer star;
    private String content;
    private Integer isPic;
    private String imgIds;

}
