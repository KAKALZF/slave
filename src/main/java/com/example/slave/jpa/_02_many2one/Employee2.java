package com.example.slave.jpa._02_many2one;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Employee2 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    //关联部门信息,多对一
    //告诉JPA,Employee和Department的关系是多对一
    //创建表:employee表(创建外键列维护两者之间的关系)和department表
    /*FetchType：
    * EAGER(饥饿加载)
    * LAZY(懒加载)
    * */

    @ManyToOne(fetch = FetchType.EAGER)
    //修改外键列的相关信息,
    @JoinColumn(name = "dept_id")
    private Department department;

    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
