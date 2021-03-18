package com.peach.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("hystrixService")
@Slf4j
public class HystrixServiceImpl implements HystrixService{
    @Override
    public String paymentInfoOK(Long id) {
        String msg = "调用成功返回，当前线程："+Thread.currentThread().getName()+" ID："+id+"\t"+"^_^";
        log.info(msg);
        return msg;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",commandProperties = {
//            这配置的是超时时间的返回 默认也自带了一个服务报错的返回 也是直接调用这个fallbackMethod
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")

    })
    public String paymentTimeout(Long id) {
        Integer timeSecend = 3000;
//        Integer timeSecend = 13000/0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeSecend);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg = "调用超时，当前线程："+Thread.currentThread().getName()+" ID："+id+"\t"+"耗时（S）："+timeSecend;
        log.info(msg);
        return msg;
    }

    public String paymentCircuteBreakerHandler(Long id){
        return Thread.currentThread().getName()+"\t"+"调用失败id不能为负数，id："+id+"，这是paymentCircuteBreakerHandler o(╥﹏╥)o";
    }


    //这里的hystrix是单独的线程池 和原本的线程池起到了隔离的作用 所以不用担心他的返回失败
    public String paymentTimeoutHandler(Long id) {
        String msg = "8001 调用超时返回或者请求错误返回，当前线程："+Thread.currentThread().getName()+" ID："+id+"\t"+"o(╥﹏╥)o";
        return msg;
    }


    //服务熔断=====
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuteBreakerHandler",commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断器
            //请求的总数评率  意思在时间窗口设置的时间内请求超过10次
            //默认百分比是一半也就是百分之五十的情况下会将断路器打开
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "1000"),//时间区间 窗口期
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率阈值
    })
    public String paymentCircuteBreaker(Long id) {
        if (id<0){
            //抛异常会导致服务熔断
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，当前id："+serialNumber;
    }




}
