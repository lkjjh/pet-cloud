package com.al.pet.controller;

import com.al.pet.model.vo.AttributeVO;
import com.al.pet.service.AttributeService;
import com.al.pet.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author al
 * @version 1.0
 */
@RestController
@RequestMapping("/product/attribute")
public class AttributeController {

    @Autowired
    private AttributeService service;

    @PostMapping("/byCategoryIds")
    public CommonResult<List<AttributeVO>> byCategoryIds(Long... secIds) {
        List<AttributeVO> vos = service.byCategoryIds(secIds);
        return vos.isEmpty()
                ? CommonResult.nullData()
                : CommonResult.ok(vos);
    }

    @GetMapping("/list")
    public CommonResult<List<AttributeVO>> list() {
        List<AttributeVO> vos = service.list();
        return vos.isEmpty()
                ? CommonResult.nullData()
                : CommonResult.ok(vos);
    }
}
