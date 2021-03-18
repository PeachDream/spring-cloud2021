package com.peach.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator consumerRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("peach_router_guonei",
                r-> r.path("/guonei")
                        .uri("http://news.baidu.com"))
                .build();
        routes.route("peach_router_guoji",
                r->r.path("/guoji")
                        .uri("http://news.baidu.com"))
                .build();
        return routes.build();
    }
}
