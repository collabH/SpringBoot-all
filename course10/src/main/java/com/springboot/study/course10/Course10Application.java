package com.springboot.study.course10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.annotation.WebServlet;

/**
 * 异常处理
 * 如何去掉Springboot默认的异常处理
 * @SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
 */
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
//@ServletComponentScan
public class Course10Application {

    public static void main(String[] args) {
        SpringApplication.run(Course10Application.class, args);
    }

}

