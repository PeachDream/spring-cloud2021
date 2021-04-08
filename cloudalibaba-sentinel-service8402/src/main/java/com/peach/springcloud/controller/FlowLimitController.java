package com.peach.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "this is testA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info("this is testB");
        return "this is testB";
    }
}
