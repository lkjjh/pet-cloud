package com.al.pet.model.vo;

import com.al.pet.model.dto.SearchProductDto;
import com.al.pet.model.pojo.Spu;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.stream.Collectors;

/**
 * 搜索结果
 *
 * @author al
 * @version 1.0
 */

public class SearchVo extends com.al.pet.util.Page<SearchProductDto> {


    public static SearchVo build(Page<Spu> page) {
        SearchVo vo = new SearchVo();
        vo.setPageNo(page.getCurrent());
        vo.setPageSize(page.getSize());
        vo.setBeginPos(page.getCurrent());
        vo.setList(page.getRecords()
                .stream()
                .map(SearchProductDto::build)
                .collect(Collectors.toList()));
        return vo;
    }

}
