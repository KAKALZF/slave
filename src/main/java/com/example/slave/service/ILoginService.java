package com.example.slave.service;

import com.example.slave.entity.Role;
import com.example.slave.entity.User;

import java.util.Map;

public interface ILoginService {
    User addUser(Map<String, Object> map);

    Role addRole(Map<String, Object> map);

    User findByName(String name);
}
