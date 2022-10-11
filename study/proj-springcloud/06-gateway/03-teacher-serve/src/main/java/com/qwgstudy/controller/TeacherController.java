package com.qwgstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @GetMapping("teacher")
    public String teacher(){
        return "tom老师正在教学java中！！！";
    }
}
