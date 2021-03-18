package com.peach.myrule;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//因为使用自己的rule不能够放在@ComponentScan 能够扫描到的包下面 也就是不能够放在主启动类所在的包com.peach.springcloud
//和他下面的子包里面 所以我们需要将这个配置类放在其他包里最好是和主启动包同级
//@Configuration
public class MyselfRule {

//    实际上没有自动引入ribbon 需要自己加入启动器
//    @Bean
//    public IRule myIRule(){
//        设置负载均衡方式为随机
//        return new RandomRule();
//    }

}
