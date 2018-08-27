package com.roy.springbootcache.service;

import com.roy.springbootcache.bean.Employee;
import com.roy.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmp(Integer id){
        System.out.println("search " + id + " employee");
        Employee employee = employeeMapper.getEmployeeById(id);
        return employee;
    }
}
