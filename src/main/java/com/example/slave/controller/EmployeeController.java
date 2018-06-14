package com.example.slave.controller;

import com.example.slave.entity.Employee;
import com.example.slave.service.EmployeeService;
import com.example.slave.service.impl.EmployeeServcieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public String insert(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setDept("技术部");
        employee.setName("浩南");
        employeeService.insert(employee);
        return "ok";
    }

}
