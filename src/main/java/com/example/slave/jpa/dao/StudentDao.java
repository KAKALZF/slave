package com.example.slave.jpa.dao;

import com.example.slave.jpa._04_many2one2many.Employee4;
import com.example.slave.jpa._05_many2many.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
}
