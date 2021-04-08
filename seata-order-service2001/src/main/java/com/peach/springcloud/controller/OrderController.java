package com.peach.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.entity.TOrder;
import com.peach.springcloud.handler.OrderControllerHandler;
import com.peach.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order/get/{id}")
    public CommonResult get(@PathVariable("id")Long id){
        return new CommonResult(200,"success",orderService.getOrder(id));
    }

    @PostMapping("/order/create")
    @SentinelResource(value = "order/create",
            blockHandlerClass = OrderControllerHandler.class,
            blockHandler = "getHandler",
            fallbackClass = OrderControllerHandler.class,
            fallback = "getFallback"
    )
    public CommonResult create(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        TOrder order = jsonObject.toJavaObject(TOrder.class);
        return new CommonResult(200,"success",orderService.create(order));
    }

}
