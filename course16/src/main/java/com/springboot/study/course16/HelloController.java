package com.springboot.study.course16;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course16
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@RestController
public class HelloController {
    @GetMapping(value = "hello")
    public String hello(){
        return "hello";
    }
}
