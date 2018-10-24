package com.example.slave.jpa._07_extends;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
//默认使用SINGLE_TABLE策略生成表,一张表维护所有的父类和子类的数据
//在表中添加一个鉴别器列,用来区分数据的类型
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="type")
//@DiscriminatorValue("1")
public class Product {
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue()
    private Long id;
    private String name;
}
