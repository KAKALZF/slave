package com.example.slave.jpa.dao;

import com.example.slave.jpa._03_one2many.Department3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Department3Dao extends JpaRepository<Department3, Long> {
}
