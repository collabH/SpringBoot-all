package com.springboot.study.course17.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Mock测试方法
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course17.mapper
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@RunWith(SpringRunner.class)
public class UserMapperTest {

    /**
     * 当UserMapper接口在spring容器中不存在时，使用@mockbean
     */
    @MockBean
    private UserMapper userMapper;

    @Test(expected = NullPointerException.class)
    public void test1(){
        /**
         * 行为预测
         */
        BDDMockito.given(userMapper.craeteUser("")).willReturn(Integer.valueOf(0));
        BDDMockito.given(userMapper.craeteUser(null)).willThrow(NullPointerException.class);
        BDDMockito.given(userMapper.craeteUser("admin")).willReturn(Integer.valueOf(1));
        Assert.assertEquals(Integer.valueOf(1),userMapper.craeteUser("admin"));
        Assert.assertEquals(Integer.valueOf(0),userMapper.craeteUser(""));
        Assert.assertEquals(Integer.valueOf(0),userMapper.craeteUser(null));
    }
}