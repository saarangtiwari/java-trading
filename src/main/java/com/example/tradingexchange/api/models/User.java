package com.example.tradingexchange.api.models;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public String email;


    User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
