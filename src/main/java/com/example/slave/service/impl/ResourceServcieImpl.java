package com.example.slave.service.impl;

import com.example.slave.dao.EmployeeDao;
import com.example.slave.dao.ResourceDao;
import com.example.slave.entity.Employee;
import com.example.slave.entity.Resource;
import com.example.slave.service.EmployeeService;
import com.example.slave.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServcieImpl implements ResourceService {
    @Autowired
    private ResourceDao resourceDao;


    @Override
    public List<Resource> findAll() {
        return resourceDao.findAll();
    }

    @Override
    public void save(Resource resource) {
        resourceDao.save(resource);
    }
}
