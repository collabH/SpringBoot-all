package com.springboot.study.course14.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course14.redis
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */

@Data
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {
    private String host;
    private Integer port;

}


