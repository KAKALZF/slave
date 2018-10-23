package com.example.slave.jpa._03_one2many;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Department3 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    //关联many方的数据，并且会创建部门和员工的中间表
    @OneToMany()
    //按照many方中的某一个属性进行排序
//    @OrderBy("name DESC")
    @OrderColumn(name = "seq")
    private List<Employee3> employees;


    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
