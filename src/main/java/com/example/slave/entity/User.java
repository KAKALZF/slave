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
    //如果这里的角色和用户是一对多的关系，只需要维护中间表的关系即可,不需要级联
    @OneToMany
    /*
    * 这样配置并没有解决中间表多方的唯一索引的问题，还是需要手动修改数据库，https://windshg.iteye.com/blog/1005385，该参考并不能解决问题
    * */
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id", unique = false)})
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
