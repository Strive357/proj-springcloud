package com.qwgstudy.clienta.controller;

import com.qwgstudy.clienta.feign.LoginFeign;
import org.checkerframework.checker.units.qual.A;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private LoginFeign loginFeign;

//    @GetMapping("test")
//        public String test(){
//            return loginFeign.login();
//        }
}
