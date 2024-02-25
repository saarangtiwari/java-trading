package com.example.tradingexchange.api.models;


import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;


@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User extends
        BaseDatabaseModel {

    public User() {
    }

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @OneToMany(mappedBy = "user")
    private List<Wallet> wallets;
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
