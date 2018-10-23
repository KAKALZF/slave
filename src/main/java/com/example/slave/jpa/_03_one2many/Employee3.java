package com.example.slave.jpa._03_one2many;

import com.example.slave.jpa._02_many2one.Department;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Employee3 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
