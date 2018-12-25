package com.springboot.study.course5.event;

import org.springframework.context.ApplicationEvent;

/**
 * 定义事件
 * @PACKAGE_NAME com.springboot.study.course5.event
 * @PROJECT_NAME springboot
 * @author  huang
 * @date  2018/12/25
 */
public class MyApplicationEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyApplicationEvent(Object source) {

        super(source);
    }
}
