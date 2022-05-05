package com.al.pet.controller;

import com.al.pet.model.pojo.PmsSku;
import com.al.pet.model.pojo.PmsSkuPic;
import com.al.pet.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author al
 * @version 1.0
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/sku/{id}")
    public PmsSku getSku(@PathVariable Long id) {
        return cartService.getSku(id);
    }

    @GetMapping("/skuPic/{skuId}")
    PmsSkuPic getSkuPic(@PathVariable Long skuId) {
        return cartService.getSkuPic(skuId);
    }
}
