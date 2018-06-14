package com.example.slave.service.impl;

import com.example.slave.entity.Employee;
import com.example.slave.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServcieImpl implements EmployeeService {

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public void insert(Employee employee) {

    }
}
