package com.example.slave.jpa._06_component;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter@Setter
//表示当前对象是可以嵌入到其他对象中的
@Embeddable
public class Address {
    private String province;//省
    private String city;//市
    private String street;//街道
}
