package com.al.pet.controller;

import com.al.pet.model.vo.BrandVo;
import com.al.pet.service.BrandService;
import com.al.pet.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述
 *
 * @author al
 * @version 1.0
 */
@RequestMapping("/product/brand")
@RestController
public class BrandController {
    @Autowired
    private BrandService service;

    @GetMapping("/list")
    public CommonResult<List<BrandVo>> list() {
        List<BrandVo> list = service.list();
        return list.isEmpty()
                ? CommonResult.nullData()
                : CommonResult.ok(list);
    }
}
