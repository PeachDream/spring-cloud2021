package com.peach.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.handler.OrderHandler;
import com.peach.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//在类上面的默认退路
@SentinelResource(defaultFallback = "defaultFallback")
public class OrderController {

    public static final String SERVER_URL="http://cloudalibaba-provider-payment";

    @Autowired
    OrderService orderService;

    @GetMapping("/order/get/{id}")
    @SentinelResource(value = "fallback",
            blockHandlerClass = OrderHandler.class,
            blockHandler = "blockHandler",
            fallbackClass = OrderHandler.class,
            fallback = "fallbackHandler"
    )
    public CommonResult get(@PathVariable("id") Long id){
        if (id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }else if (id == 5){
            throw new NullPointerException("NullPointerException,空指针没有值");
        }
        return orderService.get(id);
    }

    @GetMapping("/order/getError/{id}")
    public CommonResult getError(@PathVariable("id") Long id){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
    }

    public CommonResult defaultFallback(Long id,Throwable e){
        return new CommonResult(444,"fallback被调用了:"+e.getMessage());
    }
}
