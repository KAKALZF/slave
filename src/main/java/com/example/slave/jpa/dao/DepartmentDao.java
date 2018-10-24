package com.example.slave.jpa.dao;

import com.example.slave.jpa._02_many2one.Department;
import com.example.slave.jpa._04_many2one2many.Department4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
}