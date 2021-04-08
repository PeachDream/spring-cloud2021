package com.peach.springcloud.service;


import com.alibaba.fastjson.JSONObject;
import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.service.impl.AccountServiceHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "seata-account-service",fallback = AccountServiceHandler.class)
public interface AccountService {

    @GetMapping("/account/update")
    public CommonResult update(@RequestParam("id")Long id,@RequestParam("number")Long number);
}
