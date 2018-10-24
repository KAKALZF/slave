package com.example.slave.jpa._07_extends;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter@Setter
//@DiscriminatorValue("2")
public class Book extends Product {
    private String ISBN;
}
