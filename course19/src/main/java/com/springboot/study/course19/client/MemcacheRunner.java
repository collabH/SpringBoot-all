package com.springboot.study.course19.client;

import com.springboot.study.course19.bean.MemcacheSource;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * 初始化Memcached客户端
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course19.client
 * @PROJECT_NAME springboot
 * @date 2018/12/29
 */
@Component
public class MemcacheRunner implements CommandLineRunner {
    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private MemcacheSource memcacheSource;

    private MemcachedClient client=null;
    @Override
    public void run(String... args) throws Exception {
        try {
            client=new MemcachedClient(new InetSocketAddress(memcacheSource.getIp(),memcacheSource.getPort()));
        } catch (IOException e) {
            logger.error("inint MemcachedClient failed ",e);
        }
    }
    public MemcachedClient getClient(){
        return client;
    }
}
