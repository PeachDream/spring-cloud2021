package com.peach.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    //这里接收rabbitmq的条件是返回值类型是Consumer 并且 方法名和supplier的调用的send方法名相同
    Consumer<String> send() {
        return str -> {
            System.out.println("我是消费者"+serverPort+"，我收到了消息："+str);
        };
    }

}
