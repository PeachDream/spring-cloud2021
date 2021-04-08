package com.peach.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConsumerMain83.class,args);
    }
}
