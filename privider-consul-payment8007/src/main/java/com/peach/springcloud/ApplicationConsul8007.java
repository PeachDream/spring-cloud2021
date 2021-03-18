package com.peach.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationConsul8007 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsul8007.class,args);
    }
}
