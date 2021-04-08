package com.peach.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.entity.Payment;
import com.peach.springcloud.handler.MyHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "byResource_handler")
    public CommonResult byResource(){
        return new CommonResult(200,"按照资源名称限流OK的",new Payment(2020L,"seria2001"));
    }

//    这里需要传入的是BlockException 这一点和hystrix是相同的意思需要在这里捕获这个异常
    public CommonResult byResource_handler(BlockException e) {
        return new CommonResult(400,e.getClass().getCanonicalName()+"限流了限流了byResource_handler");
    }

//    意思我们可以把方法单独写到一个类中 然后通过blockHandlerClass blockHandler两个属性找到具体的处理类
    @GetMapping("/byCustom")
    @SentinelResource(value = "byCustom",
            blockHandlerClass = MyHandler.class,
            blockHandler = "myhandler1",// blockHandler负责的是配置中的限流违规等操作
            fallbackClass = MyHandler.class,
            fallback = "fallback" //fallback负责的是java中的异常
    )
    public CommonResult byCustom(){
        int age = 10/0;
        return new CommonResult(200,"byCustom限流OK的",new Payment(2020L,"seria2001"));
    }

}
