package com.qwgstudy.teachservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TeachServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachServiceApplication.class, args);
    }

}
