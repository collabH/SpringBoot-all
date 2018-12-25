package com.springboot.study.course10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course10.controller
 * @PROJECT_NAME springboot
 * @date 2018/12/25
 */
@Controller
public class FreemarkerController {
    /**
     * 1.在pom.xml文件添加依赖
     * 2.默认的freemarker的模版文件在classpath的templates中
     *
     * @return
     */
    @GetMapping("/show")
    public String show() {
        return "index";
    }

    @GetMapping("/info")
    public String info(Map data) {
        data.put("username","黄世民");
        return "index";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello.html";
    }
}
