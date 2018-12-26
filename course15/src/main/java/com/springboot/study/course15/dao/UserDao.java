package com.springboot.study.course15.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course15.dao
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@Component
public class UserDao {
    private Logger logger= LoggerFactory.getLogger(getClass());

    public void log(){
        logger.info("测试slf4j日志");
        logger.debug("user dao debug log");
        logger.warn("user dao warn log");
        logger.error("user dao error log");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }
}
