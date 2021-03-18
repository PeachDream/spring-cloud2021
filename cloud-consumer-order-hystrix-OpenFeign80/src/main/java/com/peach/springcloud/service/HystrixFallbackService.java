package com.peach.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class HystrixFallbackService implements HystrixService{
    @Override
    public String paymentInfoTimeout(Long id) {
        return "我是消费者，调用的HystrixFallbackService 的 paymentInfoTimeout方法";
    }

    @Override
    public String paymentInfoOK(Long id) {
        return "我是消费者，调用的HystrixFallbackService 的 paymentInfoOK方法";
    }

    @Override
    public String paymentCircuteBreaker(Long id) {
        return "我是消费者，调用的HystrixFallbackService 的 paymentCircuteBreaker方法";
    }
}
