package com.springboot.study.course10.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("StartupListener 监听到了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
