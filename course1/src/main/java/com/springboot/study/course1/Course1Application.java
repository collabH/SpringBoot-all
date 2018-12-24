package com.springboot.study.course1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * SpringBoot启动类
 *
 * @author huangsm
 * @date
 */
@SpringBootApplication
public class Course1Application {

    /**
     * 定义一个Bean
     *
     * @return
     */
    @Bean
    public Runnable createRunnable() {
        return () -> {
                   System.out.println("springboot is run");
               };
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Course1Application.class, args);

        context.getBean(Runnable.class).run();
    }
}


