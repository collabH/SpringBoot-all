package com.springboot.study.course18.register;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 服务注册
 */
@Component
public class ServiceRegister implements ApplicationRunner {

    @Value("${zookeeper.address}")
    private String zkAddress;

    /**
     * newClient第一个参数为zk地址，第二个参数为重连策略
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        CuratorFramework client= CuratorFrameworkFactory.newClient(zkAddress, new RetryOneTime(1000));
        client.start();
        client.blockUntilConnected();
        ServiceInstance<Object> instance = ServiceInstance.builder().name("testService").address("47.107.44.169").port(9000).build();
        ServiceDiscovery<Object>serviceDiscovery= ServiceDiscoveryBuilder.
                builder(Object.class).client(client).basePath("/soa").build();
        serviceDiscovery.registerService(instance);
        serviceDiscovery.start();
        System.out.println("服务注册成功");
    }
}
