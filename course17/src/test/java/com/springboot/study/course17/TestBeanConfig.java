package com.springboot.study.course17;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 测试环境的配置类
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course17
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@TestConfiguration
public class TestBeanConfig {
    @Bean
    public Runnable createRunable() {
        return () -> {
        };
    }
}
