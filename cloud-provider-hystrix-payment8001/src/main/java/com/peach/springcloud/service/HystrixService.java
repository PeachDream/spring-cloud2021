package com.peach.springcloud.service;


public interface HystrixService {

    public String paymentInfoOK(Long id);


    public String paymentTimeout(Long id);


    //服务熔断=====

    public String paymentCircuteBreaker(Long id);
}

