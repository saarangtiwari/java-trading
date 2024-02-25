package com.example.tradingexchange.api.models;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "wallets")
@EntityListeners(AuditingEntityListener.class)
public class Wallet extends BaseDatabaseModel {

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne()
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "locked_balance", nullable = false)
    private Double lockedBalance;

    public Wallet() {
    }

    public Wallet(User user, Long currencyId, Double balance, Double lockedBalance) {
        this.user = user;
        this.currency = new Currency();
        this.currency.setId(currencyId);
        this.balance = balance;
        this.lockedBalance = lockedBalance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getLockedBalance() {
        return lockedBalance;
    }

    public void setLockedBalance(Double lockedBalance) {
        this.lockedBalance = lockedBalance;
    }
}
