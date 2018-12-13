package com.example.slave.service.impl;

import com.example.slave.dao.EmployeeDao;
import com.example.slave.dao.UserDao;
import com.example.slave.entity.Employee;
import com.example.slave.entity.User;
import com.example.slave.service.EmployeeService;
import com.example.slave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServcieImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User find(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
