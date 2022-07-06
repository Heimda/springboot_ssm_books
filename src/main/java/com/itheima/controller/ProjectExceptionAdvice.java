package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @aythor YOLO
 * @create 2022--06--09 17:32
 */

//作为SpringMVC的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    Result doSystemException(SystemException exception){
//        exception.printStackTrace();
        return new Result(null, exception.getCode(), exception.getMessage());
    }
    @ExceptionHandler(BusinessException.class)
    Result doBusinessException(BusinessException exception){
//        exception.printStackTrace();
        return new Result(null, exception.getCode(), exception.getMessage());
    }

    //定义非系统异常or业务异常为 un_know异常——第三类异常
    @ExceptionHandler(Exception.class)
    Result doBusinessException(Exception exception){
        //安抚用户的作用！
        return new Result(null, Code.UN_KNOW_ERR, "系统繁忙，请稍后访问！");
    }
}
