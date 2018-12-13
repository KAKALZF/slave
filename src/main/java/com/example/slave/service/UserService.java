package com.example.slave.service;

import com.example.slave.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User find(Long id);

    void save(User user);
}
