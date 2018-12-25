package com.springboot.study.course10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试Springboot整合JSP
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course10.controller
 * @PROJECT_NAME springboot
 * @date 2018/12/25
 */
@Controller
public class JspController {

    @PostMapping(value = "/login")
    public  String login(@RequestParam(value = "username")String username,@RequestParam(value = "password")String password){
        if (username.equals(password)){
            return "ok";
        }
        return "error";
    }
}
