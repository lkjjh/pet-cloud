package com.al.pet.controller;

import com.al.pet.model.condition.SearchCondition;
import com.al.pet.model.vo.DetailVo;
import com.al.pet.model.vo.SearchVo;
import com.al.pet.service.ProductService;
import com.al.pet.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品接口
 *
 * @author al
 * @version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/search")
    public CommonResult<SearchVo> search(@RequestBody SearchCondition condition) {
        SearchVo search = productService.search(condition);
        return search.getList().isEmpty()
                ? CommonResult.nullData()
                : CommonResult.ok(search);
    }

    @GetMapping("/detail")
    public CommonResult<DetailVo> detail(Long spuId) {
        DetailVo detail = productService.detail(spuId);
        return detail.getSpu() == null
                ? CommonResult.nullData()
                : CommonResult.ok(detail);
    }
}
