package com.peach.springcloud.service;


import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.service.impl.StorageServiceHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "seata-storage-service",fallback = StorageServiceHandler.class)
public interface StorageService {

    @GetMapping("/storage/update")
    public CommonResult update(@RequestParam("id")Long id,@RequestParam("number")Integer number);
}
