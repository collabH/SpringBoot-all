package com.springboot.study.course4;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @PACKAGE_NAME com.springboot.study.course4
 * @PROJECT_NAME springboot
 * @创建人 huang
 * @创建时间 2018/12/24
 */
@Component
public class Jeep implements Runnable {
    @Async
    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10; i++) {
                System.out.println("-=====" + i);
                //TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
