package com.qwgstudy.feign.hystrix;

import com.qwgstudy.domain.Order;
import com.qwgstudy.feign.UserOrderFeign;
import org.springframework.stereotype.Component;

@Component
public class UserOrderFeignHystrix implements UserOrderFeign {
    @Override
    public Order getOrderByUserId(Integer userId) {
        System.out.println("提供者已经掉线！！");
        return null;
    }
}
