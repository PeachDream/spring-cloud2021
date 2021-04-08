package com.peach.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.entity.Payment;
import com.peach.springcloud.handler.PaymentHandler;
import com.peach.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    @SentinelResource(value = "payment_get",
            blockHandlerClass = PaymentHandler.class,
            blockHandler = "PaymentGet",
            fallbackClass = PaymentHandler.class,
            fallback = "fallback"
    )
    public CommonResult get(@PathVariable("id") Long id){
        Payment payment = paymentService.get(id);
        return new CommonResult<Payment>(200,"success,current port:"+port,payment);
    }
}
