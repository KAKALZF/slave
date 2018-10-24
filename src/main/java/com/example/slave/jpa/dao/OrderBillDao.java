package com.example.slave.jpa.dao;

import com.example.slave.jpa._05_many2many.Student;
import com.example.slave.jpa._08_casecade.OrderBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBillDao extends JpaRepository<OrderBill, Long> {
}
