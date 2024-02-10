package com.example.tradingexchange.api.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "currency_rates")
public class CurrencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Long currencyId;

    public Long baseCurrencyId;

    public double rate;

    public Timestamp timestamp;

}
