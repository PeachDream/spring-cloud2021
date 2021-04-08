package com.peach.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.peach.springcloud.entity.CommonResult;

public class PaymentHandler {

    public CommonResult paymentGet(Long id, BlockException exception){
        return new CommonResult(444,"PaymentGet出错了哟~~~~："+id);
    }

    public CommonResult fallback(BlockException exception){
        return new CommonResult(445,"PaymentGet出错了哟~~~~_fallback");
    }
}
