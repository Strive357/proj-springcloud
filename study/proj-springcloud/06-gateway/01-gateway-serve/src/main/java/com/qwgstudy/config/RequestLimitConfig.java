package com.qwgstudy.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

@Configuration
public class RequestLimitConfig {

//    根据某一个ip来限流 /doLogin 每一个ip 10s只能访问3次

    @Bean
    @Primary
    public KeyResolver ipKeyResolver(){
        System.out.println("aaaaa");
        return exchange -> Mono.just(exchange.getRequest().getHeaders().getHost().getHostString());
    }

// 针对这个路径来限制 /doLogin
//    api就是接口 外面一般把gateway api网关 新一代网关
    @Bean
    public KeyResolver apiKeyResolver(){
        System.out.println("aaaaa");
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }
}
