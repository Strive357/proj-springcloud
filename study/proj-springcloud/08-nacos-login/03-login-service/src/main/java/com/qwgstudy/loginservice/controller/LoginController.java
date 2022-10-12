package com.qwgstudy.loginservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("login")
    public String login(){
        return "登录成功!!!";
    }
}
