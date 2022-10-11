package com.qwgstudy.controller;

import com.qwgstudy.domain.Order;
import com.qwgstudy.feign.UserOrderFeign;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements UserOrderFeign {


    @Override
    public Order getOrderByUserId(Integer userId) {
        System.out.println(userId);
        Order order = Order.builder()
                    .name("番茄炒蛋")
                    .price(15D)
                    .orderId(1)
                    .build();
        return order;
    }
}
