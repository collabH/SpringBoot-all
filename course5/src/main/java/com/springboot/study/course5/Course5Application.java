package com.springboot.study.course5;

import com.springboot.study.course5.event.MyApplicationEvent;
import com.springboot.study.course5.listener.MyApplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 1. 自定义事件，一般是继承ApplicationEvent抽象类
 * 2. 定义事件监听器，一般是实现ApplicationListener接口
 * 3. 启动事件，需要把监听器加入到spring容器中   添加事件监听器app.addApplicationListener(new MyApplicationListener());
 * 4. 发布事件     app.publishEvent(new MyApplicationEvent(new Object()));
 */
@SpringBootApplication
public class Course5Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(Course5Application.class, args);
        //添加监听类到容器中
        //app.addApplicationListener(new MyApplicationListener());
        //发布事件
        app.publishEvent(new MyApplicationEvent(new Object()));
        app.stop();
        app.close();
    }

}

