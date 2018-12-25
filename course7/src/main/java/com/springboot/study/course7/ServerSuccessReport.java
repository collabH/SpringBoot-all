package com.springboot.study.course7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course7
 * @PROJECT_NAME springboot
 * @date 2018/12/25
 */

@Order(1)
@Component
public class ServerSuccessReport implements CommandLineRunner {;

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public void run(String... arg0) throws Exception {
        logger.info("==================应用程序启动完成=====================");
        logger.info("参数:{}",arg0.getClass());
    }
}
