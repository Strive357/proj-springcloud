package com.qwgstudy.feign;

import com.qwgstudy.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order-service")
public interface UserOrderFeign {

    @GetMapping("doOrder")
    public String doOrder();

//    @GetMapping("testOneUrl")
//    public String testOneUrl(String name,Integer age);
    @GetMapping("testUrl/{name}/and/{age}")
    public String testUrl(@PathVariable(value = "name") String name, @PathVariable(value = "age") Integer age);

    @GetMapping("oneParam")
    public String oneParam(@RequestParam(required = false) String name);
    @GetMapping("twoParam")
    public String twoParam(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age);
    @PostMapping("oneObj")
    public String oneObj(@RequestBody Order order);

    @PostMapping("oneObjOneParam")
    public String oneObjOneParam(@RequestBody Order order,@RequestParam(required = false) String name);
}
