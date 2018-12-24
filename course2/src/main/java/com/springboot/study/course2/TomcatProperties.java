package com.springboot.study.course2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @PACKAGE_NAME com.springboot.study.course2
 * @PROJECT_NAME springboot
 * @创建人 huang
 * @创建时间 2018/12/24
 */
@Component
@Data
@ConfigurationProperties(prefix = "ds")
public class TomcatProperties {
    /**
     * 如何注入一个集合
     */
    private List<String> hosts=new ArrayList<>();
    /*
    注入数组
     */
    private String [] ars={""};
}
