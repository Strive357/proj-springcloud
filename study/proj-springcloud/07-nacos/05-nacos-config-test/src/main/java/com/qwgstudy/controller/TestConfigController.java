package com.qwgstudy.controller;

import com.qwgstudy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfigController {

    @Autowired
    public User user;

    @GetMapping("toInfo")
    public String toInfo(){
        return user.toString();
    }
}
