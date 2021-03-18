package com.peach.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsulController {

    @Autowired
    RestTemplate restTemplate;

    public static final String INVOKE_URL="http://cloud-provider-payment/payment/";

    @RequestMapping("/consul/get")
    public String consilGet(){
        return restTemplate.getForObject(INVOKE_URL+"/consul",String.class);
    }

}
