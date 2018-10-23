package com.example.slave.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    //默认映射所有字段，需要更具体的设置可以使用@Column
    private String name;
    private String dept;
    private Integer age;
    @Transient//表示不需要映射到表中
    private BigDecimal salary;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Date getCreatTime() {
        return createTime;
    }

    public Employee setCreatTime(Date creatTime) {
        this.createTime = creatTime;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Employee setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Employee setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
