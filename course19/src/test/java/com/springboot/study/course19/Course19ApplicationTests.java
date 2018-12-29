package com.springboot.study.course19;

import com.springboot.study.course19.client.MemcacheRunner;
import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Course19ApplicationTests {

    @Autowired
    private MemcacheRunner memcacheRunner;
    @Test
    public void contextLoads() {
        MemcachedClient memcachedClient = memcacheRunner.getClient();
        //memcachedClient.set("testkey",1000,"666666");
        System.out.println("***********  "+memcachedClient.get("testkey").toString());

    }

}

