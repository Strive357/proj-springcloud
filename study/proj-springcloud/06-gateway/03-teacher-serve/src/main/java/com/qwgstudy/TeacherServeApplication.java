package com.qwgstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TeacherServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherServeApplication.class, args);
    }

}
