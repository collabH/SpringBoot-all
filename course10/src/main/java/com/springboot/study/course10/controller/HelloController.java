package com.springboot.study.course10.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course10.controller
 * @PROJECT_NAME springboot
 * @date 2018/12/25
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping(value="/info")
    public String hello(){
        return  "hello";
    }

    /**
     * 传递参数的方式
     * @param name 姓名
     * @return
     */
    @GetMapping(value="/info1")
    public String info1(@RequestParam(value = "name",required = false,defaultValue = "huangsm") String name){
        return name;
    }

    /**
     * 获取url中的参数
     * @param name
     * @return
     */
    @GetMapping(value = "/info2/{name}")
    public String info2(@PathVariable("name") String name){
        return name;
    }

    /**
     * 注入servler的api
     * @param request
     * @return
     */
    @GetMapping(value = "/info3")
    public String info3(HttpServletRequest request){
        return request.getRemoteHost();
    }
}
