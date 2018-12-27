package com.springboot.study.springbootrabbitMQ;

import com.springboot.study.springbootrabbitMQ.sender.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试RabbitMQ
 *
 * @author Enter your name here...
 * @version Enter version here..., 18/12/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitMqApplicationTests {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void contextLoads() {
        helloSender.send();
    }
}


