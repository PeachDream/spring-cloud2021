package com.peach.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.peach.springcloud.entity.CommonResult;
import com.peach.springcloud.entity.TStorage;
import com.peach.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    StorageService storageService;

    @GetMapping("/storage/update")
    public CommonResult update(@RequestParam("id")Long id,@RequestParam("number")Integer number){
        return new CommonResult(200,"操作成功",storageService.reduceStorage(id,number));
    }


}
