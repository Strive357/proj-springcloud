package com.qwgstudy.controller;

import com.qwgstudy.domain.Order;
import com.qwgstudy.feign.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class UserServiceController {

    @Autowired
    public UserOrderFeign userOrderFeign;

    @GetMapping("userDoOrder")
    public String userDoOrder(){

        System.out.println("有用户进来了！！！");
        String s =  userOrderFeign.doOrder();
    return s;
    }
//    @GetMapping("testOneUrl")
//    public String testOneUrl(String name,Integer age);
//    @GetMapping("testUrl/{name}/and/{age}")
//    public String testUrl(@PathVariable(value = "name") String name, @PathVariable(value = "age") Integer age);
//
//    @GetMapping("oneParam")
//    public String oneParam(String name);
//    @PostMapping("oneObj")
//    public String oneObj(@RequestBody Order order);
//
//    @PostMapping("oneObjOneParam")
//    public String oneObjOneParam(@RequestBody Order order,@PathVariable(value = "name") String name);
    @GetMapping("testParam")
    public String testParam(){
//        String testOneUrl = userOrderFeign.testOneUrl("李四",18);
//        System.out.println(testOneUrl);

        String testUrl = userOrderFeign.testUrl("王五",55);
        System.out.println(testUrl);

        String cxk = userOrderFeign.oneParam("张三");
        System.out.println(cxk);

        Order order1 = Order.builder().name("赵六").price(999D).time(new Date()).id(1).build();
        String oneObj = userOrderFeign.oneObj(order1);
        System.out.println(oneObj);

        Order order2 = Order.builder().name("神州").price(000D).time(new Date()).id(2).build();
        String oneObjOneParam = userOrderFeign.oneObjOneParam(order2,"神七");
        System.out.println(oneObjOneParam);
        return "ok";
    }
}
