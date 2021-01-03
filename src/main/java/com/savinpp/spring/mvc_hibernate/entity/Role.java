package com.savinpp.spring.mvc_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "authority")
    private String authority;

    public Role() {
    }

    public Role(String login, String authority) {
        this.login = login;
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "Role{" +
                "login='" + login + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
