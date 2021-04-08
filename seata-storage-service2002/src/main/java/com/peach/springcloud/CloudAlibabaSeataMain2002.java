package com.peach.springcloud;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.peach.springcloud.mapper")
@EnableAutoDataSourceProxy //开启数据源自动代理
public class CloudAlibabaSeataMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaSeataMain2002.class,args);
    }
}
