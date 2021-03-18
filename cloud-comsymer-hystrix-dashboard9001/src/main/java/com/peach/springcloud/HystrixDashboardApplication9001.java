package com.peach.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


//todo 这个东东在springcloud 2020.0.1版本未实现 不纠结 看下一个去了
@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
//想要使用这个注解给所有使用了Hystrix的微服务都展现出来就需要他们添加actuator的依赖
//在前面的项目总 我们默认都添加了actuator的
@EnableHystrixDashboard
public class HystrixDashboardApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication9001.class,args);
    }

}
