package com.peach.springcloud.impl;

import com.peach.springcloud.service.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessageProviderImpl implements IMessage {


    //这里直接装配一个桥 用来连接rabbit或者kafka
    @Autowired
    StreamBridge streamBridge;

    @Override
    public void sendMethod() {
        String message = UUID.randomUUID().toString();
        //这里说明一下这个send方法的参数 第一个参数是exchange或者topic 就是主题名称
        //默认的主题名称是通过
        //输入:    <方法名> + -in- + <index>
        //输出:    <方法名> + -out- + <index>
        //这里我们接受的时候就要用send方法 参数是consumer<String>接收
        //consumer的参数类型是这里message的类型
        streamBridge.send("send-in-0", message);
        System.out.println("************发送了message："+message);
    }
}
