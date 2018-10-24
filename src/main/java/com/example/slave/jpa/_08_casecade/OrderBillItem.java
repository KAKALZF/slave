package com.example.slave.jpa._08_casecade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter@Setter
@Entity
public class OrderBillItem {
    @Id
    @GeneratedValue
    private Long id;
    private String produceName;
}
