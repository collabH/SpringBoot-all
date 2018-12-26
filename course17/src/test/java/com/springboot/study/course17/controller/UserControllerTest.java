package com.springboot.study.course17.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 第一种方式:测试controller
 * webEnvironment代表web环境，随机端口号
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course17.controller
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    /**
     * 测试的restTemplate类，用于得到controller返回的信息
     */
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void test1(){
        String content = testRestTemplate.getForObject("/userinfo", String.class);
        Assert.assertEquals("userinfo",content);
    }

    @Test
    public void show() {
        String content = testRestTemplate.getForObject("/show?id=10", String.class);
        Assert.assertEquals("userinfo10",content);
    }
}