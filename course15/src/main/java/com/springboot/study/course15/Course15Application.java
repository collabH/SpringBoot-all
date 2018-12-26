package com.springboot.study.course15;

import com.springboot.study.course15.dao.UserDao;
import com.springboot.study.course15.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Course15Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Course15Application.class, args);
        run.getBean(UserDao.class).log();
        run.getBean(UserService.class).log();
    }

}

