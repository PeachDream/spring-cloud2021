package com.peach.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// 这个注解是向使用consul或者zookeeper作为注册中心的时候注册服务用的
@EnableDiscoveryClient //可以被发现的客户端
public class Payment8004Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004Application.class,args);
    }
}
