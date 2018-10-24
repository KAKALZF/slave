package com.example.slave.jpa.dao;

import com.example.slave.jpa._03_one2many.Employee3;
import com.example.slave.jpa._04_many2one2many.Employee4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee4Dao extends JpaRepository<Employee4, Long> {
}
