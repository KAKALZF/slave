package com.example.slave.jpa.dao;

import com.example.slave.jpa._02_many2one.Employee2;
import com.example.slave.jpa._03_one2many.Employee3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee3Dao extends JpaRepository<Employee3, Long> {
}
