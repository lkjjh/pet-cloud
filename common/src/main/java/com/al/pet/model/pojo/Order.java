package com.al.pet.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author Al
 * @version 1.0
 **/
@TableName("oms_order")
@Data
public class Order {
    @TableId(type = IdType.AUTO)
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
    private LocalDateTime expirationTime;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

}
