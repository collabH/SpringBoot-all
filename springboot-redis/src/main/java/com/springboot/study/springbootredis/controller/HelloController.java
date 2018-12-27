package com.springboot.study.springbootredis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.study.springbootredis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.springbootredis.controller
 * @PROJECT_NAME springboot
 * @date 2018/12/27
 */
@RestController
public class HelloController {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 测试缓存
     * @return
     */
    @GetMapping("/testCache")
    @Cacheable(value = "user-key")
    public User getUser(){
        String userString = JSON.toJSONString(redisTemplate.opsForValue().get("user"));
        User user = JSONObject.parseObject(userString, User.class);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    /**
     * 测试session共享
     * @param session
     * @return
     */
    @GetMapping(value = "/uid")
    public String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid==null){
            uid=UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }

    /**
     * 测试得到的sessionId
     * @param session
     * @return
     */
    @GetMapping(value = "/getSessionId")
    public String getSessionId(HttpSession session){
        return session.getId();
    }
}
