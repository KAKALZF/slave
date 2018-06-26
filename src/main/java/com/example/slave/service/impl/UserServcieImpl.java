package com.example.slave.service.impl;

import com.example.slave.dao.UserDao;
import com.example.slave.entity.User;
import com.example.slave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServcieImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        List<User> all = userDao.findAll();
        return all;
    }

    @Override
    public Page<User> page(Integer pageNum, Integer pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize);
        return userDao.findAll(pageRequest);
    }

}
