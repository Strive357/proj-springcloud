package com.qwgstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class NaconsConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaconsConfigApplication.class, args);
    }

}
