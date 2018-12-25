package com.springboot.study.course7;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *  在spring容器刷新之前执行
 * @PACKAGE_NAME com.springboot.study.course7
 * @PROJECT_NAME springboot
 * @author  huang
 * @date  2018/12/25
 */
public class MyApplicationContextInitializer2 implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("测试能看通过配置制定俩个ApplicationContextInitializer");
    }
}
