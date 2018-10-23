package com.example.slave.jpa._02_many2one;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
