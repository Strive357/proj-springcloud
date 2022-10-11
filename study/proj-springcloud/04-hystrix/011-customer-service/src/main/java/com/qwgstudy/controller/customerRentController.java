package com.qwgstudy.controller;

import com.qwgstudy.feign.CustomerRentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class customerRentController {

//    @Autowired
    @Resource
    private CustomerRentFeign customerRentFeign;

    @GetMapping("customerRent")
    public String customerRent(){
        System.out.println("BBB有人租车了!!!");
        String rent = customerRentFeign.rent();
//        String  rent = customerRentFeign.doOrder();
        return rent;
    }
}
