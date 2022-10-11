package com.qwgstudy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class consumerController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/testribbon")
    public String testribbon(String serviceName){
        String result = restTemplate.getForObject("http://" + serviceName + "/hello",String.class);
    return result;
    }
}
