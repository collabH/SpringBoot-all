package com.springboot.study.course11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course11.controller
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@RestController
public class TestController {
    @GetMapping(value ="info" )
    public  String info(){
        return "info";
    }
}
