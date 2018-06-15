package com.example.slave.service.impl;

import com.example.slave.dao.EmployeeDao;
import com.example.slave.entity.Employee;
import com.example.slave.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServcieImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public void insert(Employee employee) {
        employeeDao.save(employee);
    }
}
