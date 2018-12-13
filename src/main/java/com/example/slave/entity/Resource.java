package com.example.slave.entity;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Resource {
    @Id
    @GeneratedValue
    public Long id;
    public String name;

    public Long getId() {
        return id;
    }

    public Resource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Resource setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
