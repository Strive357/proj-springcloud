package com.qwgstudy.loginservice.controller;

import com.qwgstudy.loginservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.time.Duration;
import java.util.UUID;


@RestController
@CrossOrigin // 加上这个注解之后 这个controller里面的方法就可以直接被访问了
public class LoginController {

    @Autowired(required=false)
    private StringRedisTemplate redisTemplate;

    @GetMapping("login")
    @CrossOrigin
    public String login( String username,  String password){

        User user = new User(1,username,password,18);

        //随机创建token值
        String token = UUID.randomUUID().toString();
        //存到redis中
        redisTemplate.opsForValue().set(token,user.toString(), Duration.ofSeconds(7200));

        return token;
    }
}
