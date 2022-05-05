package com.al.pet.util;

import com.al.pet.enums.Code;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author al
 * @version 1.0.0
 * @ClassName CommonResult.java
 * @Description 描述
 * @createTime 2022年03月31日 17:46:00
 */
@Data
@NoArgsConstructor
public class CommonResult<E> {
    private Integer code;
    private String msg;
    private E data;

    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }

    public CommonResult(Integer code, String msg, E data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> CommonResult<T> ok() {
        return ok(null);
    }

    public static <T> CommonResult<T> ok(T data) {
        return new CommonResult<>(Code.OK.getCode(), Code.OK.getMessage(), data);
    }

    public static <T> CommonResult<T> error() {
        return new CommonResult<>(Code.ERROR.getCode(), Code.ERROR.getMessage());
    }

    public static <T> CommonResult<T> nullData() {
        return nullData(Code.DATA_NULL.getMessage());
    }

    public static <T> CommonResult<T> nullData(String msg) {
        return new CommonResult<>(Code.DATA_NULL.getCode(), msg);
    }

    public static <T> CommonResult<T> code(Code code) {
        return new CommonResult<>(code.getCode(), code.getMessage());
    }


}
