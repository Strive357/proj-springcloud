package com.qwgstudy.controller;

import com.qwgstudy.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
   public User user;

    @GetMapping("testConfig")
    public String testConfig(){
        return user.getName() + ":" + user.getAge()+ ":" + user.getAddress();
    }

}
