package com.peach.springcloud.controller;

import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.entity.Payment;
import com.peach.springcloud.lb.OwnLb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001/payment";
    public static final String PAYMENT_SERVER = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;

    @Autowired
    OwnLb ownLb;

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
       return restTemplate.postForObject(PAYMENT_SERVER+"/payment/create/",payment,CommonResult.class);
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id)
    {
        return restTemplate.getForObject(PAYMENT_SERVER+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/lb")
    public String lb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size()<=0){
            return null;
        }
        ServiceInstance instance = ownLb.instance(instances);
        return restTemplate.getForObject(instance.getUri()+"/payment/lb",String.class);
    }

}
