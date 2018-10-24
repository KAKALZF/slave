package com.example.slave.jpa._04_many2one2many;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Department4 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    //让one方放弃关系的维护(不会创建中间表)
    //让many方中的department属性来进行相关的关系维护
    @OneToMany(mappedBy = "department")
    private List<Employee4> employees;


    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
