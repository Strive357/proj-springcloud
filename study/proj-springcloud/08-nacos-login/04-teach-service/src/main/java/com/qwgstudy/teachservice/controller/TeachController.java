package com.qwgstudy.teachservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TeachController {

    @GetMapping("teach")

    public String teach(){
        return "老师正在教物理中！！！";
    }
}
