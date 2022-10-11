package com.qwgstudy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(value = "rent-car-service",fallback = CustomerCarFeignHystrix.class)
@FeignClient(value = "rent-car-service")
public interface CustomerCarFeign {

    @GetMapping("rent")
    public String rent();

}
