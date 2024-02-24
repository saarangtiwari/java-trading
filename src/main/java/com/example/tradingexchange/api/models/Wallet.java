package com.example.tradingexchange.api.models;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "wallets")
@EntityListeners(AuditingEntityListener.class)
public class Wallet {

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @OneToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "locked_balance", nullable = false)
    private Double lockedBalance;


    public Wallet(User user, Currency currency, Double balance, Double lockedBalance) {
        this.user = user;
        this.currency = currency;
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
