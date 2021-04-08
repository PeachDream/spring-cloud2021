package com.peach.springcloud.controller;

import com.peach.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id){
        String result = hystrixService.paymentInfoOK(id);
        log.info(result);
        return result;
    }

    @GetMapping("/payment/hystrix/zipkin")
    public String zipkin(){
        return "请求到了zipkin~~~";
    }


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Long id){
        String result = hystrixService.paymentTimeout(id);
        log.info(result);
        return result;
    }

    @GetMapping("/payment/hystrix/cb/{id}")
    public String paymentCircuteBreaker(@PathVariable("id")Long id) {
        String msg = hystrixService.paymentCircuteBreaker(id);
        log.info(msg);
        return msg;
    }
}
