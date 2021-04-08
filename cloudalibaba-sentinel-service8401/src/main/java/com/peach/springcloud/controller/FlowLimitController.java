package com.peach.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "this is testB";
    }

    @GetMapping("/testD")
    public String testD(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int age = 10/0;
        log.info("Testing testD异常比例!!!!!!");
        return "this is testD";
    }

    @GetMapping("/testHotKey")
    //设置了SentinelResource之后就可以在sentinel控制台页面设置根据这里的value值设置hotkey
    //也就是设置testHotKey的热点限流规则
    //这里如果不配置保底方法 那么系统会直接把这个异常抛出去
    @SentinelResource(value = "testHotKey",blockHandler = "testHotKey_handler")
    public String testHotKey(
//需要注意的是在sentinel中配置的index顺序是按照我们代码中的参数顺序来排序的
//            例如在当前testHotKey接口中
//            索引为0的参数是p1
//            索引为1的参数是p2
            @RequestParam(name = "p1",required = false) String p1,
            @RequestParam(name = "p2",required = false) String p2
    ){
        return "testHotKey------";
    }

    //这是上面@SentinelResource的保底方法，不知道其他限流规则有没有能够使用到这个兜底
    //测试了 其他方法不能使用这个兜底的方法
    public String testHotKey_handler(String p1, String p2, BlockException exception){
        return "testHotKey------testHotKey_handler";
    }
}
