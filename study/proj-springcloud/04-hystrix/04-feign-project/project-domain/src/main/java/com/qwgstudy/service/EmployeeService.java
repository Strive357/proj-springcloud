package com.qwgstudy.service;

import com.qwgstudy.domain.Employee;

public interface EmployeeService {
    //根据id查询
    Employee selectEmployeeByid(int id);
}
