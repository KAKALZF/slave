package com.example.slave.controller;


import com.example.slave.jpa._02_many2one.Department;
import com.example.slave.jpa._02_many2one.Employee2;
import com.example.slave.jpa.dao.DepartmentDao;
import com.example.slave.jpa.dao.Employee2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/jpa")
public class JpaTestController {
    @Autowired
    private Employee2Dao employee2Dao;
    @Autowired
    private DepartmentDao departmentDao;
    @GetMapping("/manyToOneSave")
    public String manyToOneSave() {
        /*
        * 需要先保存部门，再保存员工，否则报错
        * */
        Employee2 employee = new Employee2();
        employee.setName("kaka");
        Department department = new Department();
        department.setName("技术部");
        Department save = departmentDao.save(department);
        employee.setDepartment(save);
        employee2Dao.save(employee);
        return "ok";
    }

    @GetMapping("/manyToOneGet")
    public String manyToOneGet() {
        Employee2 one = employee2Dao.findOne(2L);
        System.out.println("===================");
        //采用的是懒加载，用到的时候采取查询部门信息
        Department department = one.getDepartment();
        System.out.println(department.toString());
        return "ok";
    }
}
