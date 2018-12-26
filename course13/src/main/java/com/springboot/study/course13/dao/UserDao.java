package com.springboot.study.course13.dao;

import org.springframework.stereotype.Component;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course13
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@Component
public class UserDao {

    public void addTest(String name) {
        System.out.println("name:"+name);
    }

}
