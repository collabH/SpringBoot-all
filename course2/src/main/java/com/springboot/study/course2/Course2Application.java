package com.springboot.study.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取配置方法
 * @author huangsm
 * @date 2018年12月24日 14:37:12
 */
@SpringBootApplication
@RestController
public class Course2Application {

    /**
     * 第一种方式获取配置文件的参数
     */
    @Autowired
    private  Environment env;

    /**
     * 第二种方式获取配置文件的参数
     */
    @Value("${huel.age}")
    private  Integer age;

    @Value("${app.name}")
    private String appName;

    @Autowired
    private Huel huel;
    /**
     * 默认值
     */
    @Value("${hello:nihao}")
    private String hello;

    @Autowired
    private TomcatProperties tomcatProperties;

    public static void main(String[] args) {
        SpringApplication.run(Course2Application.class, args);
    }





    @RequestMapping("/hello")
    public String hello(){

        return env.getProperty("huel.name")+age+appName+hello+"huel"+huel+tomcatProperties+env.getProperty("uu.name");
    }

}

