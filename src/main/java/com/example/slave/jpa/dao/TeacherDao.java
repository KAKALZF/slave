package com.example.slave.jpa.dao;

import com.example.slave.jpa._04_many2one2many.Department4;
import com.example.slave.jpa._05_many2many.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends JpaRepository<Teacher, Long> {
}
