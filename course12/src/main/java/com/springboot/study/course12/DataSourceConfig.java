package com.springboot.study.course12;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 配置Durid数据源
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course12
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource createDataSource(){
        DruidDataSource ds=new DruidDataSource();
        ds.setUrl(env.getProperty("url"));
        ds.setUsername(env.getProperty("username"));
        ds.setPassword(env.getProperty("password"));
        ds.setDriverClassName(env.getProperty("driver-class-name"));
        return  ds;
    }
}
