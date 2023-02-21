package com.alberto.app.person.model.dto;

import java.io.Serializable;

public class TeacherDto extends PersonDto implements Serializable {
    private static final long serialVersionUID = 1L;

    public TeacherDto(String id, String name, String lastName, String code, String email, String password, String country, String province, String district, Boolean isActive) {
        super(id, name, lastName, code, email, password, country, province, district, isActive);
    }
}
