package com.example.slave.dao;

import com.example.slave.entity.User;

public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
}

