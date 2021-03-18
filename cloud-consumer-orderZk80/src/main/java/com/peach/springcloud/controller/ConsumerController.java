package com.peach.springcloud.controller;


import com.peach.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {

    public static final String INVOKE_URL= "http://cloud-payment-service/payment/zk";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk/get")
    public String zkget(){
        return restTemplate.getForObject(INVOKE_URL, String.class);
    }
}
