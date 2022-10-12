package com.qwgstudy.clienta.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "teach-service")
public interface TeachFeign {
    @GetMapping("teach")
     String teach();
}
