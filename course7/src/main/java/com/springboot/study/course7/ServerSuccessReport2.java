package com.springboot.study.course7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course7
 * @PROJECT_NAME springboot
 * @date 2018/12/25
 */

@Order(2)
@Component
public class ServerSuccessReport2 implements CommandLineRunner {;

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public void run(String... arg0) throws Exception {
        logger.info("==================应用程序启动时间:{}", LocalDateTime.now().toString());
    }
}
