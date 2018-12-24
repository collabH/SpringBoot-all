package com.springboot.study.course3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Conditional;

/**
 * 课程三Spring Boot 自动配置
 * @author huangsm
 * @date 2018年12月24日 15:51:12
 */
@SpringBootApplication
public class Course3Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Course3Application.class, args);
        System.out.println(run.getBean(EncodingConvert.class));
        System.out.println(run.getBean(Runnable.class));
    }

}

