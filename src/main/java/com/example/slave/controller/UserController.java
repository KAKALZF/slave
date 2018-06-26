package com.example.slave.controller;

import com.example.slave.Bean.ResponseBean;
import com.example.slave.entity.User;
import com.example.slave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ResponseBean findAll() {
        List<User> all = userService.findAll();
        return new ResponseBean().setData(all);
    }

    @RequestMapping("/page")
    public ResponseBean page(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<User> userPage = userService.page(page, size);
        return new ResponseBean().setData(userPage);
    }

}
