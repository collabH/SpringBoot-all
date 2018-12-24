package com.springboot.study.course2;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * @PACKAGE_NAME com.springboot.study.course2
 * @PROJECT_NAME springboot
 * @author  huang
 * @date 2018/12/24
 */
@SpringBootConfiguration
@Profile("dev")
public class MyConfig {

    @Bean
    public Runnable createRunnable() {
        System.out.println("====1====");
        return () -> {
        };
    }

    /**
     * 指定dev环境注入bean
     * @return
     */
    @Bean
    @Profile("dev")
    public Runnable createRunnable1() {
        System.out.println("====2====");
        return () -> {
        };
    }

    /**
     * 指定prod环境注入bean
     * @return
     */
    @Bean
    @Profile("prod")
    public Runnable createRunnabl2() {
        System.out.println("====3====");
        return () -> {
        };
    }
}
