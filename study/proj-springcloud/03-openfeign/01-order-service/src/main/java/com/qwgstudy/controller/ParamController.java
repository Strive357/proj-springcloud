package com.qwgstudy.controller;

import com.qwgstudy.domain.Order;
import org.springframework.web.bind.annotation.*;

/**
 * url /doOrder/热干面/add/油条
 * get传递一个参数
 * get传递多个参数
 * post传递一个对象
 * post传递一个对象+一个基本参数
 */
@RestController
public class ParamController {
    @GetMapping("testOneUrl")
    public String testOneUrl(String name,Integer age){
        System.out.println(name + ":" + age);
        return "ok";
    }
    @GetMapping("testUrl/{name}/and/{age}")
    public String testUrl(@PathVariable(value = "name") String name,@PathVariable(value = "age") Integer age){
        System.out.println(name + ":" + age);
        return "ok";
    }
  @GetMapping("oneParam")
    public String oneParam(@RequestParam(required = false) String name){
      System.out.println(name);
        return "ok";
    }
    @GetMapping("twoParam")
    public String twoParam(@RequestParam(required = false) String name,@RequestParam(required = false) Integer age){
        System.out.println(name);
        System.out.println(age);
        return "ok";
    }

    @PostMapping("oneObj")
    public String oneObj(@RequestBody Order order){
        System.out.println(order);
        return "ok";
    }

    @PostMapping("oneObjOneParam")
    public String oneObjOneParam(@RequestBody Order order,@RequestParam(required = false) String name){
        System.out.println(order);
        System.out.println(name);
        return "ok";
    }
}
