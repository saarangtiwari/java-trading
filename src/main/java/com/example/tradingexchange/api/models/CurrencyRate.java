package com.example.tradingexchange.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Table(name = "currency_rates")
@EntityListeners(AuditingEntityListener.class)
public class CurrencyRate extends BaseDatabaseModel {

    public Long currencyId;

    public Long baseCurrencyId;

    public double rate;

    public Timestamp timestamp;

    public CurrencyRate(Long currencyId, Long baseCurrencyId, double rate, Timestamp timestamp) {
        this.currencyId = currencyId;
        this.baseCurrencyId = baseCurrencyId;
        this.rate = rate;
        this.timestamp = timestamp;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getBaseCurrencyId() {
        return baseCurrencyId;
    }

    public void setBaseCurrencyId(Long baseCurrencyId) {
        this.baseCurrencyId = baseCurrencyId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
