package com.qwgstudy.service.imp;

import com.qwgstudy.dao.EmployeeDao;
import com.qwgstudy.domain.Employee;
import com.qwgstudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;
    @Override
    public Employee selectEmployeeByid(int id) {
//        查询数据库
           Employee employee = employeeDao.selectEmployeeByid(id);

        return employee;
    }
}
