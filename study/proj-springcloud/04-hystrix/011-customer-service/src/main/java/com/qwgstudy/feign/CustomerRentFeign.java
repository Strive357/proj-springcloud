package com.qwgstudy.feign;

import com.qwgstudy.feign.hystrix.CustomerRentFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(value = "order-service")
@FeignClient(value = "rent-service",fallback = CustomerRentFeignHystrix.class)
public interface CustomerRentFeign {
    @GetMapping("rent")
    public String rent();

//    @GetMapping("doOrder")
//    public String doOrder();
}
