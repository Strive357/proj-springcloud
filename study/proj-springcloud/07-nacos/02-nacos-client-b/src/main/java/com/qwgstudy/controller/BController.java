package com.qwgstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BController {

    @GetMapping("info")
    public String info(){
        return "你好我是B客户端的！";
    }
}
