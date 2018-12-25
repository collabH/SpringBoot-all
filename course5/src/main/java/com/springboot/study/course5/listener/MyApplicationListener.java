package com.springboot.study.course5.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME com.springboot.study.course5.listener
 * @PROJECT_NAME springboot
 * @author  huang
 * @date  2018/12/25
 */
//@Component
public class MyApplicationListener implements ApplicationListener {
    /**
     *
     * @param event 需要监听的时间
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("接收事件:"+event.getClass());
    }
}
