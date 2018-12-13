package com.example.slave.service;

import com.example.slave.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findOne(Long id);

    void save(Role role);
}
