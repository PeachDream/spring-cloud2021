package com.peach.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
//如果不加上这个RefreshScope那么就不会触发自动刷新
@RefreshScope //一个配置注解这样他就具备了刷新能力了 这里需要加上不管他是server还是client端都需要
//但是这里的配置刷新还需要一个手动的post请求才能够生效
// curl -X POST "http://localhost:3355/actuator/refresh"  也就是使用post请求请求一下这个接口
public class ConfigController {

    @Value("${server.port}")
    private String port;

    @Value("${server.info}")
    private String configInfo;

    @GetMapping("/get")
    public String getConfig(){
        return port+":"+configInfo;
    }
}
