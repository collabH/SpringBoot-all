package com.springboot.study.course10.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 定义一个过滤器
 */
@WebFilter("/*")
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("income log filter"+servletRequest.getRemoteHost());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
