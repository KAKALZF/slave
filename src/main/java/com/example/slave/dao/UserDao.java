package com.example.slave.dao;

import com.example.slave.entity.Employee;
import com.example.slave.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
