package com.example.tradingexchange.api.models;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "currency_pairs")
@EntityListeners(AuditingEntityListener.class)
public class CurrencyPair extends BaseDatabaseModel {
    public String name;
    public double current_price;

    @OneToOne
    @JoinColumn(name = "target_currency_id", referencedColumnName = "id")
    private Currency targetCurrency;

    @OneToOne
    @JoinColumn(name = "base_currency_id", referencedColumnName = "id")
    private Currency baseCurrency;


    public CurrencyPair() {
    }

    public CurrencyPair(String name, double current_price, Currency baseCurrency, Currency targetCurrency) {
        this.name = name;
        this.current_price = current_price;
        this.targetCurrency = targetCurrency;
        this.baseCurrency = baseCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(Currency targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(double current_price) {
        this.current_price = current_price;
    }


}
