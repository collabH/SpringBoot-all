package com.springboot.study.course17;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course17
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestBeanConfig.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void addUser() {
        Integer num = userDao.addUser(null);
        System.out.println(num);
    }
    @Autowired
    private ApplicationContext context;
    @Test
    public void testNull() {
        Assert.assertNotNull(context.getBean(Runnable.class));
    }
}