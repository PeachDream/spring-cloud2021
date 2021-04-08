package com.peach.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.peach.springcloud.entity.CommonResult;


public class MyHandler {
    public static CommonResult myhandler1(BlockException e){
        return new CommonResult(444,"myhandler11111111111");
    }
    public static CommonResult myhandler2(BlockException e){
        return new CommonResult(444,"myhandler222222222222");
    }

    public static CommonResult fallback(Throwable e){
        return new CommonResult(555,"fallbackl了:"+e.getMessage());
    }
}
