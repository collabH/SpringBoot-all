package com.springboot.study.course4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @EnableAsync
 */
@SpringBootApplication
@EnableAsync
@Import(User.class)
public class Course4Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Course4Application.class, args);
        run.getBean(Runnable.class).run();
        System.out.println(run.getBean(User.class));
        System.out.println("----end---");
        run.close();
    }

}

