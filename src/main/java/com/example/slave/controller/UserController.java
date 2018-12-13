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
        User user = new User().setName("kaka").setPassword("test");
        Random random = new Random();
        Role r1 = new Role().setName("角色" + random.nextInt(100));
        Role r2 = new Role().setName("角色" + random.nextInt(100));
        roleService.save(r1);
        roleService.save(r2);
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(r1);
        roles.add(r2);
        user.setRoles(roles);
        userService.save(user);
        return "ok";
    }

    @GetMapping("/update")
    public String update() {
        User user = userDao.findOne(1L);
        user.setName("nameUpate");
        //更新多方的角色
        List<Role> roles = user.getRoles();
        Role one = roleDao.findOne(6L);
        System.out.println("================" + one);
        roles.add(one);
        //对象已存在，更新
        userDao.save(user);

        return "success";
    }

    @GetMapping("/delete")
    public String delete() {
        return "success";
    }
}
