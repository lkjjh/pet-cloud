package com.al.pet.model.vo;

import com.al.pet.model.dto.CartDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author al
 * @version 1.0
 */
@Data
public class OrderPreSubmitVO {
    private List<CartDTO> productList;
    private BigDecimal totalMoney;
    private BigDecimal payMoney;
    private BigDecimal freight = new BigDecimal("0.99");

    public static OrderPreSubmitVO build(List<CartDTO> productList) {
        OrderPreSubmitVO orderVO = new OrderPreSubmitVO();
        orderVO.setProductList(productList);
        orderVO.setTotalMoney(new BigDecimal("0"));
        productList.forEach(p -> orderVO.setTotalMoney(orderVO.getTotalMoney().add(p.getPrice())));
        orderVO.setPayMoney(orderVO.getTotalMoney());
        return orderVO;
    }
}
