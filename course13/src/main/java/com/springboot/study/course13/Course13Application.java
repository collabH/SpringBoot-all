package com.springboot.study.course13;

import com.springboot.study.course13.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy //启用aop
public class Course13Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Course13Application.class, args);
        run.getBean(UserDao.class).addTest("黄世民");
    }

}

