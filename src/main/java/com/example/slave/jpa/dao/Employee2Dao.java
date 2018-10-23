package com.example.slave.jpa.dao;

import com.example.slave.jpa._02_many2one.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee2Dao extends JpaRepository<Employee2, Long> {
}
