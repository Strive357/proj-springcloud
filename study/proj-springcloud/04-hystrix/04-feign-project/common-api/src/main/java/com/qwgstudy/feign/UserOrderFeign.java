package com.qwgstudy.feign;

import com.qwgstudy.domain.Order;
import com.qwgstudy.feign.hystrix.UserOrderFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "order-servicecenter",fallback = UserOrderFeignHystrix.class)
public interface UserOrderFeign {

    @GetMapping("/order/getOrderByUserId")
    Order getOrderByUserId(@RequestParam Integer userId);

}
