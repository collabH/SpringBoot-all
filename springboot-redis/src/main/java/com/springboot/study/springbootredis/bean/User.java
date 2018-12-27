package com.springboot.study.springbootredis.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.springbootredis.bean
 * @PROJECT_NAME springboot
 * @date 2018/12/27
 */
@Data
public class User implements Serializable {
    private String name;
    private Integer age;
}
