package com.alberto.core.account.model.entity;

import com.alberto.core.account.model.domain.Role;
import com.alberto.core.person.model.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_account")
public class AccountEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Role role;

    public AccountEntity(String name, String lastName, String code, String email, String password, String country, String province, String district, Boolean isActive, Role role) {
        super(name, lastName, code, email, password, country, province, district, isActive);
        this.role = role;
    }

    public AccountEntity() {

    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
