package com.springboot.study.course10.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 配置类方式实现
 */
public class EchoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        System.out.println("spring boot filter"+request.getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
