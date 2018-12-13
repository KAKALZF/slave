package com.example.slave.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String password;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    public List<Role> roles;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
