package com.itheima.controller;


import lombok.Data;

/**
 * @aythor YOLO
 * @create 2022--06--08 11:34
 */
@Data
public class Result {
    private Object data;
    private String msg;
    private Integer code;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public Result(Object data, Integer code, String msg) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }
}
