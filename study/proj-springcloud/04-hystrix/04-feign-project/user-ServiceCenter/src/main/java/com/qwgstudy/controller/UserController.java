package com.qwgstudy.controller;

import com.qwgstudy.domain.Order;
import com.qwgstudy.feign.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserOrderFeign userOrderFeign;

    @GetMapping("find")
    public Order findOrder(){
        return userOrderFeign.getOrderByUserId(1);
    }
}
