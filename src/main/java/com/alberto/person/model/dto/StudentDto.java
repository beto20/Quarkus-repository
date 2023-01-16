package com.alberto.person.model.dto;

import java.io.Serializable;

public class StudentDto extends PersonDto implements Serializable {
    private static final long serialVersionUID = 1L;

    public StudentDto(String name, String lastName, String email, String password, String country, String province, String district, Boolean isActive) {
        super(name, lastName, email, password, country, province, district, isActive);
    }
}
