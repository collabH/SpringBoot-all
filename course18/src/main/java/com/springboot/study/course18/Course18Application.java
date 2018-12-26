package com.springboot.study.course18;

import com.springboot.study.course18.bean.Test;
import com.springboot.study.course18.mapper.TestMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
@MapperScan("com.springboot.study.course18.mapper")
public class Course18Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Course18Application.class, args);
        List<Test> list = run.getBean(TestMapper.class).findList();
        System.out.println(list);

    }

}

