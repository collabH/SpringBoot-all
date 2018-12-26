package com.springboot.study.course10.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course10.exception
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@RestControllerAdvice
public class GolbalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String errorHandler(Exception e){
        return e.getMessage();
    }
}
