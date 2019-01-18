package com.example.slave.service.impl;

import com.example.slave.dao.EmployeeDao;
import com.example.slave.dao.RoleDao;
import com.example.slave.entity.Employee;
import com.example.slave.entity.Role;
import com.example.slave.service.EmployeeService;
import com.example.slave.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServcieImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findOne(Long id) {
        return roleDao.findOne(id);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
