package com.springboot.study.course10.exception;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 错误页面处理
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course10.exception
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
//@Component
public class CommonErrorPageRegistry implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage e404=new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
        ErrorPage e500=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html");
        ErrorPage args = new ErrorPage(InterruptedException.class, "/args.html");
        registry.addErrorPages(e404,e500,args);
    }
}
