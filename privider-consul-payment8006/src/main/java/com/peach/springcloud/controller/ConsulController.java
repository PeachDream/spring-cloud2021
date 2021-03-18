package com.peach.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ConsulController {

    @Value("${server.port}")
    private String serverPort;

    //测试代表当前服务注册是成功的。
    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "spring cloud consul:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
