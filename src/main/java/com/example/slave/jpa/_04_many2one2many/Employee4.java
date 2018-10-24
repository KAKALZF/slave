package com.example.slave.jpa._04_many2one2many;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Employee4 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    //不用加joinColumn?
    private Department4 department;

    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
