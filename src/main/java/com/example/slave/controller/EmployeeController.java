package com.example.slave.controller;

import com.example.slave.entity.Employee;
import com.example.slave.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/insert")
    public String insert() {
        Employee employee = new Employee();
//        employee.setId(1L);
        employee.setDept("技术部");
        employee.setName("kaka123");
        employee.setCreatTime(new Date());
        employeeService.insert(employee);
        kafkaTemplate.send("mykafka", "kakalzf");
        return "ok";
    }

    @RequestMapping("/hello")
    public String hello() {
        Subject subject = SecurityUtils.getSubject();
        System.out.println("用户名:" + subject.getPrincipal().toString());
        Session session = subject.getSession();
        Collection<Object> attributeKeys = session.getAttributeKeys();
        System.out.println("所有的属性");
        for (Object attributeKey : attributeKeys) {
            System.out.println("key:" + attributeKey.toString());
            System.out.println("value:" + session.getAttribute(attributeKey.toString()));
        }
        long timeout = session.getTimeout();
        Date date = new Date(timeout);
        System.out.println("超时时间:" + date);
        System.out.println(subject.getSession());
        System.out.println(Thread.currentThread().getName());
        return "ok";
    }


    @GetMapping("findEmps")
    public List<Employee> findEmps() {
        List<Employee> all = employeeService.findAll();
        return all;
    }
}
