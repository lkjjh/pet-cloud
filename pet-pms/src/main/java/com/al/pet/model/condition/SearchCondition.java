package com.al.pet.model.condition;

import lombok.Data;

import java.util.List;

/**
 * 商品搜索参数
 *
 * @author al
 * @version 1.0
 */
@Data
public class SearchCondition {

    private Long brandId;
    private Long productLevel1CategoryId;
    private Long productLevel2CategoryId;
    private String keyword;
    private Integer productAttributeSize;
    private List<Integer> productAttributeIds;
    private Integer sort;
    private Integer pageNo = 1;
    private Integer pageSize = 20;
    private Integer beginPos = 0;

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        if (pageSize != null)
            beginPos = (pageNo - 1) * pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if (pageNo != null)
            beginPos = (pageNo - 1) * pageSize;
    }
}
