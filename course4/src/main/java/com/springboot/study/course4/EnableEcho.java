package com.springboot.study.course4;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 只要spring容器bean的包在这里，就在spring装配起来打印出来
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EchoImportBeanDefinitionRegistrar.class)
public @interface EnableEcho {
    String[] packages();
}
