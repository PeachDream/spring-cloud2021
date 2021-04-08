package com.peach.springcloud.service;

import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.serviceImpl.OrderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "cloudalibaba-provider-payment",contextId = "payment",fallback = OrderServiceImpl.class)
public interface OrderService {

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id);
}
