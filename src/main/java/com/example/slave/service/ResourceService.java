package com.example.slave.service;

import com.example.slave.entity.Resource;
import com.example.slave.entity.User;

import java.util.List;

public interface ResourceService {
    List<Resource> findAll();

    void save(Resource resource);
}
