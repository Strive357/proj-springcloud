package com.qwgstudy.clienta.controller;

import com.qwgstudy.clienta.feign.TeachFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeachController {

    @Autowired
    private TeachFeign teachFeign;

    @GetMapping("doTeach")
    public String doTeach(){
        return teachFeign.teach();
    }
}
