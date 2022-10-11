package com.qwgstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("doOrder")
    public String doOrder(){
        return "油条饼-热干面";
    }
}
