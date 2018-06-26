package com.example.slave.service;


import com.example.slave.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<User> findAll();

    Page<User> page(Integer pageNum, Integer pageSize);
}
