package com.peach.springcloud.controller;


import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.entity.Payment;
import com.peach.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        if (result>0){
            log.info("**************插入成功****::::serverPort:"+serverPort,result);
            return new CommonResult(200,"插入成功serverPort:"+serverPort,result);
        }else{
            log.info("**************插入失败***********************");
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.selectById(id);
        if (payment != null){
            log.info("******************查询成功******serverPort:"+serverPort,payment);
            return new CommonResult(200,"查询成功serverPort:"+serverPort,payment);
        }else{
            log.info("**************查询失败***********************");
            return new CommonResult(444,"查询失败",null);
        }
    }

    @GetMapping("/lb")
    public String lbprovider(){
        return "从provider返回了，端口号:"+this.serverPort;
    }


    @GetMapping("/feign/timeout")
    public String feignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
