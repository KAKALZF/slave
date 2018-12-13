package com.example.slave.controller;

import com.example.slave.service.ResourceService;
import com.example.slave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @GetMapping("/query")
    public String query() {
        return "success";
    }

    @GetMapping("/save")
    public String save() {
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
}
