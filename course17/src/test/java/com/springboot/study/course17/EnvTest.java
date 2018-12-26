package com.springboot.study.course17;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试配置文件中得值
 * springboot会优先加载测试环境下的配置文件，测试环境下没有才会加载正式环境下的配置文件
 *
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course17
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"name=huangsm"})
public class EnvTest {
    @Autowired
    private Environment env;

    @Before
    public void init(){

    }

    @Test
    public void testValue(){
        Assert.assertEquals("springboot",env.getProperty("app"));
        Assert.assertEquals("huangsm",env.getProperty("name"));
    }
}
