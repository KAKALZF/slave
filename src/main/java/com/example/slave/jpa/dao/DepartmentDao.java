package com.example.slave.jpa.dao;

import com.example.slave.jpa._02_many2one.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
}
