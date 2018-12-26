package com.springboot.study.course17;

import org.springframework.stereotype.Repository;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course17
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@Repository
public class UserDao {
    public Integer addUser(String username) {
        System.out.println("user dao adduser");
        if (username == null) {
            return 0;
        } else {
            return 1;
        }
    }
}
