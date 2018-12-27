package com.springboot.study.springbootrabbitMQ.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 *
 * @author huang
 * @PACKAGE_NAME com.springboot.study.springbootrabbitMQ.config
 * @PROJECT_NAME springboot
 * @date 2018/12/27
 */
@Configuration
@EnableRabbit
public class RabbitConfig {


    /**
     * 装配一个消息队列，名为hello
     * @return
     */
    @Bean
    public Queue queue(){
        return  new Queue("hello");
    }
}
