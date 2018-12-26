package com.springboot.study.course17.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 第二种方式:测试controller(只测试controller，不会加载整合spring容器)
 * controllers指定测试那个controller
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course17.controller
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest2 {


    @Autowired
    private MockMvc mvc;
    @Test
    public void test1() throws Exception {
        //希望返回ok状态
        mvc.perform(MockMvcRequestBuilders.get("/userinfo")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void show() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/show").param("id","4999")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}