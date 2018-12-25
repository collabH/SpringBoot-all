package com.springboot.study.course5;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME com.springboot.study.course5
 * @PROJECT_NAME springboot
 * @创建人 huang
 * @创建时间 2018/12/25
 */
@Component
public class MyEventHandle {
    /**
     * 蚕食一定要是ApplicationEvent，或者其子类
     *
     * @param event
     */
    @EventListener
    public void event(ApplicationEvent event) {
        System.out.println("接收事件:" + event.getClass());
    }

    /**
     * 应用停止事件
     *
     * @param event
     */
    @EventListener
    public void event2(ContextStoppedEvent event) {
        System.out.println("接收事件:" + event.getClass());
    }
}
