package com.springboot.study.springbootrabbitMQ.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * RabbitMQ消息发送者
 * @author huang
 * @PACKAGE_NAME com.springboot.study.springbootrabbitMQ.sender
 * @PROJECT_NAME springboot
 * @date 2018/12/27
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send(){
        String context="hello"+ LocalDateTime.now().toString();
        System.out.println("发送内容:"+context);
        //发送信息
        this.rabbitTemplate.convertAndSend("hello",context);
    }
}
