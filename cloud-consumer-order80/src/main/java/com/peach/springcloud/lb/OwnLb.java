package com.peach.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class OwnLb implements LoadBalance{

    //原子Integer 0
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = getAndIncrement()%instances.size();
        return instances.get(index);
    }

    //定义操作且增加方法
    private final int getAndIncrement(){
        int current;
        int next;
        for(;;){
            //获取当前原子Integer 不会因为多线程导致这个数获取的变化
            current = atomicInteger.get();
            next = current>2147483647?0:current+1;
            //原子操作 我们的期望值是current 改变之后的值是next如果compareOK那么就可以返回
            //如果不ok就继续取值和赋值
            if (this.atomicInteger.compareAndSet(current,next))
                log.info("当前访问次数："+next);
                return next;
        }
    }
}
