package com.peach.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.peach.springcloud.mapper")
public class AlibabaPaymentMain9004 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPaymentMain9004.class,args);
    }
}
