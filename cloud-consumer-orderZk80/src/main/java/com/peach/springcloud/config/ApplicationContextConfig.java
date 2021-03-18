package com.peach.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //没有负载均衡就会出现UnknownHostException异常
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}