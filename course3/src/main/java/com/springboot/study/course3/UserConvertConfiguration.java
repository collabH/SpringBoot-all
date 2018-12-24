package com.springboot.study.course3;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * @PACKAGE_NAME com.springboot.study.course3
 * @PROJECT_NAME springboot
 * @创建人 huang
 * @创建时间 2018/12/24
 */
@SpringBootConfiguration
public class UserConvertConfiguration {
    /**
     * 当配置文件中的runable.enabled为true时才装配
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(name = "runable.enabled", havingValue = "true")
    public Runnable createRunnable() {
        return () -> {
        };
    }

    /**
     * 当classPath存在类路径下有Gson才装配
     * @return
     */
    @Bean
    @ConditionalOnClass(name = "com.google.gson.Gson")
    public Runnable createRunnable1() {
        return () -> {
        };
    }

    /**
     * 当Spring容器中存在一个叫user的bean时才装配
     * @return
     */
    @Bean
    @ConditionalOnBean(name = "user")
    public Runnable createRunnable3() {
        return () -> {
        };
    }

    /**
     * 当Spring容器中不存在user中才装配
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "user")
    public Runnable createRunnable4() {
        return () -> {
        };
    }
}
