package com.springboot.study.springbootredis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Session配置
 * @author huang
 * @PACKAGE_NAME com.springboot.study.springbootredis.config
 * @PROJECT_NAME springboot
 * @date 2018/12/27
 * maxInactiveIntervalInSeconds: 设置Session失效时间，
 * 使用Redis Session之后，原Boot的server.session.timeout属性不再生效
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30)
public class SessionConfig {
}
