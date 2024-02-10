package com.example.tradingexchange.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String code;
    public String name;

}
