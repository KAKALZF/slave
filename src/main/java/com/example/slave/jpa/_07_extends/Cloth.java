package com.example.slave.jpa._07_extends;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter@Setter
//@DiscriminatorValue("3")
public class Cloth  extends Product{
    private String color;
}
