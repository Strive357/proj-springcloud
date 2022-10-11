package com.qwgstudy.feign.hystrix;


import com.qwgstudy.feign.CustomerRentFeign;
import org.springframework.stereotype.Component;

@Component
public class CustomerRentFeignHystrix implements CustomerRentFeign {
    @Override
    public String rent() {
        System.out.println("租车提供者掉线拉！！");
        return null;
    }
}
