package com.example.tradingexchange.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "currency_pairs")
@EntityListeners(AuditingEntityListener.class)
public class CurrencyPair extends BaseDatabaseModel {
    public String name;
    public double current_price;

    private Long baseCurrencyId;

    private Long targetCurrencyId;

    public CurrencyPair(String name, double current_price, Long baseCurrencyId, Long targetCurrencyId) {
        this.name = name;
        this.current_price = current_price;
        this.baseCurrencyId = baseCurrencyId;
        this.targetCurrencyId = targetCurrencyId;
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

    public Long getBaseCurrencyId() {
        return baseCurrencyId;
    }

    public void setBaseCurrencyId(Long baseCurrencyId) {
        this.baseCurrencyId = baseCurrencyId;
    }

    public Long getTargetCurrencyId() {
        return targetCurrencyId;
    }

    public void setTargetCurrencyId(Long targetCurrencyId) {
        this.targetCurrencyId = targetCurrencyId;
    }
}
