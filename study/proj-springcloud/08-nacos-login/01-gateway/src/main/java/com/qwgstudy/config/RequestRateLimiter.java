package com.qwgstudy.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

@Configuration
public class RequestRateLimiter {

    // 针对某一个接口 ip来限流  /doLogin    每一个ip 10s只能访问3次
    @Bean
    @Primary // 主候选的
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getHeaders().getHost().getHostString());

    }
}
