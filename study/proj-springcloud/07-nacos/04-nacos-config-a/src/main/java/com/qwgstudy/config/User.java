package com.qwgstudy.config;

import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RefreshScope
@Component
public class User {


    @Value("${hero.name}")
    public String name;

    @Value("${hero.age}")
    public Integer age;

    @Value("${hero.address}")
    public String address;

}
