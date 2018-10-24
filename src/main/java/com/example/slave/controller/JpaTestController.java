package com.example.slave.controller;


import com.example.slave.jpa._02_many2one.Department;
import com.example.slave.jpa._02_many2one.Employee2;
import com.example.slave.jpa._03_one2many.Department3;
import com.example.slave.jpa._03_one2many.Employee3;
import com.example.slave.jpa._04_many2one2many.Department4;
import com.example.slave.jpa._04_many2one2many.Employee4;
import com.example.slave.jpa._05_many2many.Student;
import com.example.slave.jpa._05_many2many.Teacher;
import com.example.slave.jpa._06_component.Address;
import com.example.slave.jpa._06_component.Company;
import com.example.slave.jpa._08_casecade.OrderBill;
import com.example.slave.jpa._08_casecade.OrderBillItem;
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

    //==================many2many=================
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;

    /*多对多会创建中间表，当时中间表并没有保存，什么回事？怎样才能保存?*/
    @GetMapping("/manyToManySave")
    public String manyToManySave() {
        Student student = new Student();
        student.setName("lin");
        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();
        t1.setName("li");
        t2.setName("han");
        ArrayList<Teacher> teachers = new ArrayList<>();
        t1 = teacherDao.save(t1);
        t2 = teacherDao.save(t2);
        teachers.add(t1);
        teachers.add(t2);
        student.setTeachers(teachers);
        studentDao.save(student);
        return "ok";
    }

    @GetMapping("/manyToManyGet")
    public String manyToManyGet() {
        Student one = studentDao.getOne(1L);
        System.out.println(one.toString());
        List<Teacher> teachers = one.getTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
        return "ok";
    }

    //==================component=================================

    @Autowired
    private CompanyDao companyDao;

    @GetMapping("/component")
    public String component() {
        Company company = new Company();
        company.setName("枫叶科技");
        Address address = new Address();
        address.setProvince("广东省");
        address.setCity("广州市");
        address.setStreet("天河区");
        Address regAdd = new Address();
        regAdd.setProvince("北京市");
        regAdd.setCity("海淀区");
        regAdd.setStreet("解放街道");
        company.setAddress(address);
        company.setRegAddress(regAdd);
        companyDao.save(company);
        return "ok";
    }

    //===================casecade=============================

    @Autowired
    private OrderBillDao orderBillDao;
    @Autowired
    private OrderBillItemDao orderBillItemDao;

    @GetMapping("/casecadeSave")
    public String casecadeSave() {
        OrderBill orderBill = new OrderBill();
        orderBill.setSn("test");
        ArrayList<OrderBillItem> items = new ArrayList<>();
        OrderBillItem item1 = new OrderBillItem();
        OrderBillItem item2 = new OrderBillItem();
        item1.setProduceName("铅笔");
        item2.setProduceName("手抄本");
        items.add(item1);
        items.add(item2);
        orderBill.setItems(items);
        orderBillDao.save(orderBill);
        return "ok";
    }

    @GetMapping("/casecadeDel")
    public String casecadeDel() {
        OrderBill one = orderBillDao.findOne(1L);
        orderBillDao.delete(one);
        return "ok";
    }
}
