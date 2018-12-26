package com.springboot.study.course19.client;

import com.google.gson.Gson;
import com.springboot.study.course19.Test;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

/**
 * 服务发现客户端
 */
public class Client {
    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient("47.107.44.169:2181", new RetryOneTime(1000));
        client.start();
        client.blockUntilConnected();
        ServiceDiscovery<Object> serviceDiscovery= ServiceDiscoveryBuilder.
                builder(Object.class).client(client).basePath("/soa").build();
        Collection<ServiceInstance<Object>> list = serviceDiscovery.queryForInstances("testService1");
        list.forEach((instance)->{
            RestTemplate rs=new RestTemplate();
            List<Test> forObject = rs.getForObject("http://" + instance.getAddress() + ":" + instance.getPort() + "/info", List.class);
            for (Test test : forObject) {
                System.out.println(test);
            }
            System.out.println(instance.getAddress());
            System.out.println(instance.getPort());
        });
    }
}
