package com.peach.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/nacos")
public class AlibabaPyamentController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/get/{string}")
    public String get(@PathVariable String string){
        return "nacos registry,server port:"+port+"\t"+"id:"+string;
    }

}
