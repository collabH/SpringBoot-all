package com.springboot.study.course7;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course7
 * @PROJECT_NAME springboot
 * @date 2018/12/25
 */
@Component
public class StartedApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("应用已经启动");
    }
}
