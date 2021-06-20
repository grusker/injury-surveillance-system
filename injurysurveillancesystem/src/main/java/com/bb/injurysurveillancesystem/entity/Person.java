package com.bb.injurysurveillancesystem.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
    protected String name;
    protected String surname;
    protected String email;
    protected String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}