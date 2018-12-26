package com.springboot.study.course14.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course14.redis
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@Configuration
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(Jedis.class)
    public Jedis jedis(RedisProperties redisProperties){
        Jedis jedis = new Jedis(redisProperties.getHost(), redisProperties.getPort());
        return jedis;
    }
}
