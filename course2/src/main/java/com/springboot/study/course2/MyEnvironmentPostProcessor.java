package com.springboot.study.course2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 动态获取配置文件
 * @PACKAGE_NAME com.springboot.study.course2
 * @PROJECT_NAME springboot
 * @创建人 huang
 * @创建时间 2018/12/24
 */
@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {
    /**
     * 读取f盘中的springboot.properties文件
     * @param environment
     * @param application
     */
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try (InputStream inputStream = new FileInputStream("F:\\temp\\springboot.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("my", properties);
            environment.getPropertySources().addLast(propertiesPropertySource);
        } catch (IOException e) {

        }
    }
}
