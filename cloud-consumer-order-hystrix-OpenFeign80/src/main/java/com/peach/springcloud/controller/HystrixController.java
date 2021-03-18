package com.peach.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.peach.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//这里指定了一个这个类的默认回调方法 如果没有使用@HystrixCommand 定制 就使用这个方法
//注意 这里的方法不能够使用以及被定制化的fallback回调函数 例如 paymentInfoTimeoutHandler
//使用了paymentInfoTimeoutHandler 这个方法会直接找不到
//@DefaultProperties(defaultFallback = "global_fallback_handler")
public class HystrixController {

    @Autowired
    HystrixService hystrixService;

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Long id){
        log.info("****调用/consumer/hystrix/timeout/{id} id："+id);
        return hystrixService.paymentInfoTimeout(id);
    }

    //这里没有明确指出降级的fallback方法 所以会去找default 的fallback方法
//    @HystrixCommand
    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id){
        log.info("****调用/consumer/hystrix/ok/{id} id："+id);
        return hystrixService.paymentInfoOK(id);
    }

    @GetMapping("/consumer/hystrix/cb/{id}")
    public String paymentCircuteBreaker(@PathVariable("id") Long id){
        log.info("****调用/consumer/hystrix/cb/{id} id："+id);
        return hystrixService.paymentCircuteBreaker(id);
    }

    public String paymentInfoTimeoutHandler(@PathVariable("id") Long id){
        String msg = "我是消费者80 我在调用调用/consumer/hystrix/timeout/Handler 超时了o(╥﹏╥)o id："+id;
        log.info(msg);
        return msg;
    }

    public String global_fallback_handler(){
        String msg = "我是消费者80 这是一个全局的fallback处理方法";
        return msg;
    }

}
