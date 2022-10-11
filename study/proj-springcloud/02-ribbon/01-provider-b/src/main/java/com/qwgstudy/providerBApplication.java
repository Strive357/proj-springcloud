package com.qwgstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class providerBApplication {

    public static void main(String[] args) {
        SpringApplication.run(providerBApplication.class, args);
    }

}
