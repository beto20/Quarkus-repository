package com.alberto.app.account.model.dto;

import com.alberto.app.person.model.dto.PersonDto;
import com.alberto.core.account.model.domain.Role;

import java.io.Serializable;

public class AccountDto extends PersonDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Role role;

    public AccountDto() {
    }

    public AccountDto(String id, String name, String lastName, String code, String email, String password, String country, String province, String district, Boolean isActive, Role role) {
        super(id, name, lastName, code, email, password, country, province, district, isActive);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
