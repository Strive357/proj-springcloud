package com.qwgstudy.clienta.controller;

import com.qwgstudy.clienta.feign.LoginFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController {

    @Autowired
    private LoginFeign loginFeign;

    @GetMapping("doLogin")
    public String doLogin( String username,String password){
        return loginFeign.login(username,password);
        }
}
