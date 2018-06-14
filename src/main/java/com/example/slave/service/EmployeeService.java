package com.example.slave.service;

import com.example.slave.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    void insert(Employee employee);
}
