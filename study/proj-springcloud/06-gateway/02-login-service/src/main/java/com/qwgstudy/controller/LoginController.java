package com.qwgstudy.controller;

import com.qwgstudy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.UUID;

@RestController
public class LoginController {

    @Autowired
    public StringRedisTemplate redisTemplate;

    @GetMapping("doLogin")
    public String doLogin(String name,String pwd){
        System.out.println(name);
        System.out.println(pwd);
//        假设查到数据库内容
        User user = new User(1,name,pwd,18);
        String token = UUID.randomUUID().toString();
//        存到redis数据库中
        redisTemplate.opsForValue().set(token,user.toString(),Duration.ofSeconds(7200));
        return token;
    }
}
