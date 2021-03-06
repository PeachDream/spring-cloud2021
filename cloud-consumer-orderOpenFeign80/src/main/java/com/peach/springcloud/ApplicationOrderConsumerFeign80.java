package com.peach.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients //开启Feign配置 之后在客户端的service中才能够使用@FeignClient作为FeignClient对象使用
public class ApplicationOrderConsumerFeign80{

    public static void main(String[] args) {
        SpringApplication.run(ApplicationOrderConsumerFeign80.class,args);
    }

}
