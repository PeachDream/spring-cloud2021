package com.peach.springcloud.controller;


import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.entity.Payment;
import com.peach.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;


    @Resource
    DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        if (result>0){
            log.info("**************插入成功*************::::serverPort:"+serverPort,result);
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
            log.info("******************查询成功**********::serverPort:"+serverPort,payment);
            return new CommonResult(200,"查询成功::serverPort:"+serverPort,payment);
        }else{
            log.info("**************查询失败***********************");
            return new CommonResult(444,"查询失败",null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service:services){
            log.info("***service:"+service);
        }


        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/zipkin")
    public String zipkin(){
        return "zipkin 从provider返回了，端口号:"+this.serverPort;
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
