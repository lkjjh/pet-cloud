package com.al.pet.enums;

/**
 * 响应状态
 *
 * @author Al
 * @version 1.0
 **/
public enum Code {
    /**
     * 操作成功
     */
    OK(200, "操作成功"),
    /**
     * 系统异常
     */
    ERROR(500, "系统异常"),
    /**
     * 操作失败
     */
    OPERATIO_FAILURE(0, "操作失败"),
    /**
     * 发送短信失败
     */
    FAILED_SEND_SMS(10001, "发送验证码失败"),
    /**
     * 发送验证码成功
     */
    SUCCESS_SEND_SMS(10002, "发送验证码成功"),
    /**
     * 操作频繁
     */
    OPERATING_FREQUENCY(10003, "操作频繁"),
    /**
     * 验证码不正确
     */
    SMS_IS_INCORRECT(10004, "验证码不正确"),
    TOKEN_OUT(4011, "token不存在"),
    TOKEN_ERROR_CHECK(4012, "token验证失败"),
    DATA_NULL(404, "数据走丢了~");
    private Integer code;
    private String message;

    Code(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
