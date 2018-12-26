package com.springboot.study.course14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import redis.clients.jedis.Jedis;

@SpringBootApplication
@EnableRedisRepositories
public class Course14Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Course14Application.class, args);
        Jedis jedis=run.getBean(Jedis.class);
        jedis.set("id","1234");
        System.out.println(jedis.get("id"));
    }

}

