package com.springboot.study.course15.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course15.service
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@Service
public class UserService {
    private Logger logger= LoggerFactory.getLogger(getClass());

    public void log(){
        logger.info("测试slf4j日志");
        logger.debug("user dao debug log");
        logger.warn("user dao warn log");
        logger.error("user dao error log");
    }
}
