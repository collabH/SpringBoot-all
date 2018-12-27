package com.springboot.study.springbootrabbitMQ.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ消息接收者
 * @author huang
 * @PACKAGE_NAME com.springboot.study.springbootrabbitMQ.receiver
 * @PROJECT_NAME springboot
 * @date 2018/12/27
 */
@Component
public class HelloReceiver {
    @RabbitListener(queues = "hello")
    public void process(String hello){
        System.out.println("接收的消息为:"+hello);
    }
}
