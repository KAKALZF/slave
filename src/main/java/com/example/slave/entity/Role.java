package com.example.slave.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue
    public Long id;
    public String name;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Resource> resources;

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public Role setResources(List<Resource> resources) {
        this.resources = resources;
        return this;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
