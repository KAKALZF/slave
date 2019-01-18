package com.example.slave.controller;

import com.example.slave.dao.RoleDao;
import com.example.slave.dao.UserDao;
import com.example.slave.entity.Role;
import com.example.slave.entity.User;
import com.example.slave.service.RoleService;
import com.example.slave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @GetMapping("/query")
    public String query() {
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
            for (Role role : user.getRoles()) {
                System.out.println(role);
            }
            ;
        }
        return "success";
    }

    @GetMapping("/save")
    public String save() {
        Random random = new Random();
        int i = random.nextInt(100);
        User user = new User().setName("kaka"+i).setPassword("test"+i);
        ArrayList<Long> roleIds = new ArrayList<>();
        roleIds.add(1L);
        roleIds.add(2L);
        List<Role> roles = roleDao.findAll(roleIds);
        System.out.println("查找role==========");
        for (Role role : roles) {
            System.out.println(role);
        }
        user.setRoles(roles);
        userDao.save(user);
        return "ok";
    }

    @GetMapping("/update")
    public String update() {
        User user = userDao.findOne(1L);
        user.setName("nameUpate2");
        //更新多方的角色
        List<Role> roles = user.getRoles();
        Role one = roleDao.findOne(3L);
        System.out.println("================" + one);
//        Role roleUpdate = new Role().setName("roleUpdate");
        roles.add(one);
        roles.remove(0);
        //对象已存在，更新
        userDao.save(user);
        return "success";
    }

    @GetMapping("/delete")
    public String delete() {
        userDao.delete(1L);
        return "success";
    }
}
