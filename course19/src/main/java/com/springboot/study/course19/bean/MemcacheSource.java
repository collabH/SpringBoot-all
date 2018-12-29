package com.springboot.study.course19.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course19.bean
 * @PROJECT_NAME springboot
 * @date 2018/12/29
 */
@Component
@ConfigurationProperties(prefix = "memcache")
@Data
public class MemcacheSource {
    private String ip;
    private Integer port;
}
