package com.al.pet.model.vo;

import com.al.pet.model.condition.OrderInfoCondition;
import com.al.pet.util.Constants;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 订单信息
 *
 * @author al
 * @version 1.0
 */
@Data
public class OrderVO {

    private Long id;
    private Long userId;
    private String orderNo;
    private BigDecimal totalMoney;
    private BigDecimal payMoney;
    private Integer totalNum;
    private Integer payType;
    private Integer orderStatus;
    private Integer payStatus;
    private LocalDateTime payTime;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String codeUrl;
    private LocalDateTime expirationTime;

    public static OrderVO build(OrderInfoCondition condition, OrderPreSubmitVO preSubmitVO) {
        OrderVO vo = new OrderVO();
        vo.setUserId(condition.getUserId());
        vo.setOrderNo(UUID.randomUUID().toString());
        vo.setTotalMoney(preSubmitVO.getTotalMoney());
        vo.setPayMoney(preSubmitVO.getPayMoney());
        vo.setPayType(Constants.Order.PayWay.CASH_ON_DELIVERY);
        vo.setTotalNum(condition.getSkuInfos().size());
        vo.setOrderStatus(Constants.Order.Status.OBLIGATION);
        vo.setPayStatus(Constants.Order.PayStatus.WAIT);
        vo.setReceiverName(condition.getReceiverName());
        vo.setReceiverPhone(condition.getReceiverPhone());
        vo.setReceiverAddress(condition.getReceiverAddress());
        vo.setExpirationTime(LocalDateTime.now().plusMinutes(30L));
        return vo;
    }

}
