package com.peach.springcloud.controller;

import com.peach.springcloud.impl.MessageProviderImpl;
import com.peach.springcloud.service.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private MessageProviderImpl messageProvider;

    @RequestMapping("/send")
    public void send(){
        messageProvider.sendMethod();
    }
}
