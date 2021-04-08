package com.peach.springcloud.serviceImpl;

import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Override
    public CommonResult get(Long id) {
        return new CommonResult(444,"发生了错误，这是OrderServiceImpl兜底");
    }
}
