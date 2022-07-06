package com.itheima.exception;

/**
 * @aythor YOLO
 * @create 2022--06--09 16:23
 */
public class BusinessException extends RuntimeException{
    public Integer code;

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

}
