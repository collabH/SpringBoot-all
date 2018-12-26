package com.springboot.study.course13.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * AOP开发
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course13.aop
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@Aspect
@Component
public class Log {
    @Pointcut("execution(public * com.springboot.study.course13.dao.*.*(..))")
    public void webLog(){}

    /**
     * 在方法执行前调用
     */
    @Before("webLog()")
    public void log(){
        System.out.println("method log done");
    }

    /**
     *  后置通知
     *  在方法执行后调用
     * @param point
     */
    @After("webLog()")
    public void logAfter(JoinPoint point){
        System.out.println("after method log done"+point.getTarget().getClass()+",args:"+ Arrays.asList(point.getArgs())+"methodname:"+point.getSignature().getName());
    }
}
