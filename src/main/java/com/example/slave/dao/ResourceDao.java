package com.example.slave.dao;

import com.example.slave.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceDao extends JpaRepository<Resource, Long> {
}
