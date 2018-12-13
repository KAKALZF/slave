package com.example.slave.controller;

import com.example.slave.entity.Role;
import com.example.slave.service.RoleService;
import com.example.slave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/query")
    public String query() {
        return "success";
    }

    @GetMapping("/save")
    public String save() {
        Random random = new Random();
        int i = random.nextInt(100);
        Role role = new Role().setName("角色" + i);
        roleService.save(role);
        return "success";
    }

    @GetMapping("/update")
    public String update() {
        return "success";
    }

    @GetMapping("/delete")
    public String delete() {
        return "success";
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int m = random.nextInt(100);
            System.out.println(m);
        }
    }
}
