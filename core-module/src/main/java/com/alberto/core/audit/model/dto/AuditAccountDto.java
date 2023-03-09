package com.alberto.core.audit.model.dto;

public class AuditAccountDto {
    private String id;
    private String name;
    private String lastName;
    private String code;
    private String email;
    private String password;
    private String country;
    private String province;
    private String district;
    private Boolean isActive = Boolean.TRUE;

    public AuditAccountDto(String id, String name, String lastName, String code, String email, String password, String country, String province, String district, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.code = code;
        this.email = email;
        this.password = password;
        this.country = country;
        this.province = province;
        this.district = district;
        this.isActive = isActive;
    }

    public AuditAccountDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

}
