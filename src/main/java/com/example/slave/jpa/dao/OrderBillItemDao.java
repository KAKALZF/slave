package com.example.slave.jpa.dao;

import com.example.slave.jpa._08_casecade.OrderBill;
import com.example.slave.jpa._08_casecade.OrderBillItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBillItemDao extends JpaRepository<OrderBillItem, Long> {
}
