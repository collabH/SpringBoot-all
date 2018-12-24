package com.springboot.study.course2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME com.springboot.study.course2
 * @PROJECT_NAME springboot
 * @author  huang
 * @date  2018/12/24
 */
@Data
@Component
@ConfigurationProperties(prefix = "huel")
public class Huel {
    private String name;
    private Integer age;
}
