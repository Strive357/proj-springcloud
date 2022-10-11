package com.qwgstudy.controller;

import com.qwgstudy.feign.CustomerCarFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {


    @Autowired
    private CustomerCarFeign customerCarFeign;

    @GetMapping("customerRent")
    public String customerRent(){
        System.out.println("租客要来了！");
        String rent = customerCarFeign.rent();
        return rent;
    }
}
