package com.springboot.study.course1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * SpringBoot入口类
 */
@SpringBootApplication
public class Course1Application {

    /**
     * 定义一个Bean
     * @return
     */
    @Bean
    public Runnable createRunnable() {
        return () -> {
            System.out.println("springboot is run");
        };
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Course1Application.class, args);
        context.getBean(Runnable.class).run();

    }

}

