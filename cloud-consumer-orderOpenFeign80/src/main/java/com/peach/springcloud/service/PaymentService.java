package com.peach.springcloud.service;


import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //这代表是feign的客户端程序 这里需要标明我们的服务提供者的名称
@Component//这个接口需要被注入到ioc容器中
public interface PaymentService {

    //这里面的方法和服务提供者的controller中的方法一致
    //这里的GetMapping 和里面的path地址都 不能直接干掉 干掉之后会报错
    //同时这里的自带轮询方式的负载均衡
    //这里注册之后 在eureka注册服务界面找不到当前这个消费者 只能够找到两个服务提供者。
    // Method PaymentService#getPayment(Long) not annotated with HTTP method type (ex. GET, POST)
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);


    @GetMapping("/payment/feign/timeout")
    public String feignTimeout();


}
