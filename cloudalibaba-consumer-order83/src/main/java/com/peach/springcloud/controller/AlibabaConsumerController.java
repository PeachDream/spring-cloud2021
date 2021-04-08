package com.peach.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class AlibabaConsumerController {

    @Value("${server.port}")
    private String port;

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${service-url.nacos-user-service}")
    private String SERVER_URL;


    @GetMapping("/payment/nacos/get/{id}")
    public String get(@PathVariable("id") Long id){
        String url = SERVER_URL+"/payment/nacos/get/"+id;
        System.out.println("调用的url："+url);
        return restTemplate.getForObject(url,String.class);
    }
}
