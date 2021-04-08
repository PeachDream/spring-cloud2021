package com.peach.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaSentinelMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaSentinelMain8401.class,args);
    }
}
