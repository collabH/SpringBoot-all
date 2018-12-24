package com.springboot.study.course3;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @PACKAGE_NAME com.springboot.study.course3
 * @PROJECT_NAME springboot
 * @创建人 huang
 * @创建时间 2018/12/24
 */
@SpringBootConfiguration
public class EncodingConvertConfiguration {
    /**
     * 不装配UTF8实体类
     * @return
     */
    @Conditional(UTF8EncodingConvertImpl.class)
    @Bean
    public EncodingConvert createUTF8EncodingConvert(){
        return new UTF8EncodingConvertImpl();
    }
    @Bean
    public EncodingConvert createGBKEncodingConvert(){
        return new GBKEncodingConvertImpl();
    }
}
