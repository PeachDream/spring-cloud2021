package com.peach.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//设置某一个服务提供者的负载均衡方式为自定义的方式
//@RibbonClient(name = "cloud-payment-service",configuration = MyselfRule.class)
public class MainOrder80 {
    public static void main(String[] args) {
         SpringApplication.run(MainOrder80.class,args);
    }
}
