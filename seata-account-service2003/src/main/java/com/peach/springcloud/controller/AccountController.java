package com.peach.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.entity.TAccount;
import com.peach.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account/update")
    public CommonResult update(@RequestParam("id")Long id,@RequestParam("number")Long number){
        return new CommonResult(200,"success",accountService.reduceAccount(id,number));
    }


}
