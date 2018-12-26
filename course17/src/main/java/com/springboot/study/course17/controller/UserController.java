package com.springboot.study.course17.controller;

import com.springboot.study.course17.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course17.controller
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @GetMapping(value = "userinfo")
    public String info() {
        System.out.println("userinfo");
        return "userinfo";
    }
    @GetMapping(value = "show")
    public String show(@RequestParam("id")String id) {
        userDao.addUser(id);
        System.out.println("userinfo"+id);
        return "userinfo"+id;
    }
}
