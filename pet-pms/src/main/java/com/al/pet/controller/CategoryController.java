package com.al.pet.controller;

import com.al.pet.model.dto.CategoryDto;
import com.al.pet.service.CategoryService;
import com.al.pet.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * 商品分类接口
 *
 * @author al
 * @version 1.0
 */
@RestController
@RequestMapping("/product/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public CommonResult<List<CategoryDto>> list() {
        List<CategoryDto> list = categoryService.list();
        return Objects.isNull(list)
                ? CommonResult.nullData()
                : CommonResult.ok(list);
    }


}
