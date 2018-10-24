package com.example.slave.jpa._08_casecade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class OrderBill {
    @Id
    @GeneratedValue
    private Long id;
    private String sn;
    //在保存订单的时候,同时将关联的订单明细保存到数据库中
    //REMOVE:级联删除主对象中关联的从对象,遍历当前的集合属性,将其中的OrderBillItem删除
    //orphanRemoval:孤儿删除,删除没有了关系的数据
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
    private List<OrderBillItem> items;
}
