package com.qwgstudy.clienta.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "login-service")
public interface LoginFeign {

    @GetMapping("login")
    public String login();
}
