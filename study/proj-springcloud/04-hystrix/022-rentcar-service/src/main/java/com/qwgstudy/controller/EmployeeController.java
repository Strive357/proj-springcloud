package com.qwgstudy.controller;

import com.qwgstudy.domain.Employee;
import com.qwgstudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("select")
    public String select(@RequestParam(required = false) int id){

        Employee employee = employeeService.selectEmployeeByid(id);
        System.out.println(employee);
        return "查询成功!";
    }
}
