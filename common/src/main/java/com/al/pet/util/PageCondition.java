package com.al.pet.util;

import lombok.Data;

/**
 * @author al
 * @version 1.0.0
 * @ClassName Page.java
 * @Description 描述
 * @createTime 2022年03月31日 18:01:00
 */
@Data
public class PageCondition {
    private Long pageNo = 1L;
    private Long pageSize = 20L;
    private Long beginPos;


}
