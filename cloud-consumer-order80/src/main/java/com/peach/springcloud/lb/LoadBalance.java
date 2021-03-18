package com.peach.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {
//    这个接口方法用于收集当前服务器中能够使用的services
    ServiceInstance instance(List<ServiceInstance> instances);
}
