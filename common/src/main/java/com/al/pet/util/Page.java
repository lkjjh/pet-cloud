package com.al.pet.util;

import lombok.Data;

import java.util.List;

/**
 * @author al
 * @version 1.0.0
 * @ClassName Page.java
 * @Description 描述
 * @createTime 2022年03月31日 18:09:00
 */
@Data
public class Page<E> extends PageCondition {
    private Long total;
    private Long pages;
    private List<E> list;

    public Page() {
    }

    public Page(Long total) {
        this(total, null);
    }

    public Page(long total, List<E> list) {
        this.total = total;
        this.list = list;
    }

    public Page<E> get(PageCondition condition) {
        if (total == null || condition == null)
            return this;
        setPageNo(condition.getPageNo());
        setPageSize(condition.getPageSize());
        pages = total % getPageSize() == 0
                ? total / getPageSize()
                : total / getPageSize() + 1;
        return this;
    }


}
