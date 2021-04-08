package com.peach.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.peach.springcloud.entity.CommonResult;

//写在其他类的fallback方法和blockHandler需要加上static
public class OrderHandler {
    public static CommonResult fallbackHandler(Long id,Throwable e){
        return new CommonResult(444,"fallback被调用了:"+e.getMessage());
    }

    public static CommonResult blockHandler(Long id, BlockException blockException){
        return new CommonResult(555,"blockHandler被调用了。。。:"+blockException.getMessage());
    }
}
