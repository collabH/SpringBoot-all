package com.springboot.study.course10.servlet;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.util.Arrays;

/**
 * Servlet配置类
 */
//@SpringBootConfiguration
public class ServletConfig {
    /**
     * 装配ServletRegistrationBean
     * @return
     */
    @Bean
    public ServletRegistrationBean createBookServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new BookServlet(),"/book.do");

        return registrationBean;
    }

    /**
     * 通过配置方式装配filter
     * @return
     */
    @Bean
    public FilterRegistrationBean createEchoFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new EchoFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/book.do"));
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean createListener(){
        ServletListenerRegistrationBean<StartupListener> listener = new ServletListenerRegistrationBean<>(new StartupListener());
        return  listener;
    }
}
