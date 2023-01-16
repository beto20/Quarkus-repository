package com.alberto.person.model.dto;

import java.io.Serializable;

public class AccountRequestDto extends StudentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    public AccountRequestDto(String name, String lastName, String email, String password, String country, String province, String district, Boolean isActive) {
        super(name, lastName, email, password, country, province, district, isActive);
    }
}
