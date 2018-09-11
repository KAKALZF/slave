package com.example.slave.controller;

import com.example.slave.entity.Employee;
import com.example.slave.service.EmployeeService;
import com.example.slave.service.impl.EmployeeServcieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/insert")
    public String insert() {
        Employee employee = new Employee();
//        employee.setId(1L);
        employee.setDept("技术部");
        employee.setName("浩南");
        employeeService.insert(employee);
        kafkaTemplate.send("mykafka", "浩南");
        return "ok";
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("hello");
        return "ok";
    }
 /*   public empList(){

    }*/
}
