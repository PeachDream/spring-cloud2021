package com.peach.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import com.peach.springcloud.entity.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

public class OrderControllerHandler {

    public static CommonResult getHandler(@RequestParam JSONObject jsonObject, BlockException blockException){
        return new CommonResult(44444,"出现了错误调用了handler");
    }

    public static CommonResult getFallback(@RequestParam JSONObject jsonObject, BlockException blockException){
        return new CommonResult(44455,"出现了错误调用了Fallback");
    }
}
