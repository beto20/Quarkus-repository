package com.alberto.person.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tb_student")
public class StudentEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public StudentEntity(String name, String lastName, String code, String email, String password, String country, String province, String district, Boolean isActive) {
        super(name, lastName, code, email, password, country, province, district, isActive);
    }
}
