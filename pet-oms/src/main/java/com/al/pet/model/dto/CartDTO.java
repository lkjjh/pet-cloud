package com.al.pet.model.dto;

import com.al.pet.model.pojo.PmsSku;
import com.al.pet.util.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author al
 * @version 1.0
 */
@Data
public class CartDTO {

    private Long userId;
    private Long spuId;
    private Long skuId;
    private String title;
    private String picUrl;
    private BigDecimal unitPrice;
    private Integer num;
    private BigDecimal price;
    private String unit;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime addTime = LocalDateTime.now();

    public static CartDTO build(PmsSku sku) {
        CartDTO dto = new CartDTO();
        dto.setSpuId(sku.getSpuId());
        dto.setSkuId(sku.getId());
        dto.setTitle(sku.getTitle());
        dto.setUnitPrice(sku.getPrice());
        dto.setUnit(sku.getUnit());
        return dto;
    }

    public void setNum(Integer num) {
        this.num = num;
        if (unitPrice != null)
            price = unitPrice.multiply(new BigDecimal(num));
    }

    public String getPicUrl() {
        return Constants.Address.ADDRESS + picUrl;
    }
}
