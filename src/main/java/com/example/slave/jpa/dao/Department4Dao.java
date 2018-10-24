package com.example.slave.jpa.dao;

import com.example.slave.jpa._03_one2many.Department3;
import com.example.slave.jpa._04_many2one2many.Department4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Department4Dao extends JpaRepository<Department4, Long> {
}
