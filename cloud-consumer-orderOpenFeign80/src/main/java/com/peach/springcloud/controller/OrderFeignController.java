package com.peach.springcloud.controller;

import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.entity.Payment;
import com.peach.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    //这里注入我们编写好的FeignClient的service
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/feign/get/{id}")
    public CommonResult<Payment> comsumerFeignGet(@PathVariable("id") Long id){
        return paymentService.getPayment(id);
    }

    @GetMapping("/consumer/feign/timeout")
    public String feignTimeout(){
        return paymentService.feignTimeout();
    }
}
