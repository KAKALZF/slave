package com.example.slave.jpa._06_component;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private Address address;//公司地址
    //映射当前对象中的相关属性的列名
    @AttributeOverrides(
            {
                    @AttributeOverride(name="province",column =@Column(name="reg_province") ),
                    @AttributeOverride(name="city",column =@Column(name="reg_city") ),
                    @AttributeOverride(name="street",column =@Column(name="reg_street") )
            }
    )
    private Address regAddress;//注册地址
}
