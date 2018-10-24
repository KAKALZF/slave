package com.example.slave.controller;


import com.example.slave.jpa._02_many2one.Department;
import com.example.slave.jpa._02_many2one.Employee2;
import com.example.slave.jpa._03_one2many.Department3;
import com.example.slave.jpa._03_one2many.Employee3;
import com.example.slave.jpa._04_many2one2many.Department4;
import com.example.slave.jpa._04_many2one2many.Employee4;
import com.example.slave.jpa.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/jpa")
public class JpaTestController {
    //==================many2one=================
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

    //==================one2many=================
    @Autowired
    private Employee3Dao employee3Dao;
    @Autowired
    private Department3Dao department3Dao;

    @GetMapping("/oneToManySave")
    public String oneToManySave() {
        Employee3 employee1 = new Employee3();
        Employee3 employee2 = new Employee3();
        employee1.setName("kaka");
        employee2.setName("lin");
        Employee3 e1 = employee3Dao.save(employee1);
        Employee3 e2 = employee3Dao.save(employee2);
        ArrayList<Employee3> emps = new ArrayList<>();
        //思考 employee1和e1的区别
        emps.add(employee1);
        emps.add(employee2);
        Department3 department = new Department3();
        department.setName("技术部");
        department.setEmployees(emps);
        Department3 save = department3Dao.save(department);
        return "ok";
    }

    @GetMapping("/oneToManyGet")
    public String oneToManyGet() {
        Department3 one = department3Dao.findOne(2L);
        System.out.println("===================");
        List<Employee3> employees = one.getEmployees();
        for (Employee3 employee : employees) {
            System.out.println(employee.toString());
        }
        return "ok";
    }


    //==================oneToManyToOne=================
    @Autowired
    private Employee4Dao employee4Dao;
    @Autowired
    private Department4Dao department4Dao;

    @GetMapping("/oneToManyToOneSave")
    public String oneToManyToOneSave() {
        /*
        * 需要先保存部门，再保存员工，否则报错
        * */
        Employee4 employee = new Employee4();
        employee.setName("kaka");
        Department4 department = new Department4();
        department.setName("技术部");
        Department4 save = department4Dao.save(department);
        employee.setDepartment(save);
        employee4Dao.save(employee);
        return "ok";
    }

    @GetMapping("/oneToManyToOneGet")
    public String oneToManyToOneGet() {
        System.out.println("根据员工查部门");
        Employee4 one = employee4Dao.findOne(2L);
        System.out.println("===================");
        //采用的是懒加载，用到的时候采取查询部门信息
        Department4 department = one.getDepartment();
        System.out.println(department.toString());
        System.out.println("根据部门查员工");
        Department4 dept = department4Dao.getOne(2L);
        List<Employee4> employees = dept.getEmployees();
        for (Employee4 employee : employees) {
            System.out.println(employee.toString());
        }
        return "ok";
    }
}
