package com.example.tradingexchange.api.models;

import com.example.tradingexchange.enums.OrderStatus;
import com.example.tradingexchange.enums.OrderType;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseDatabaseModel {


    private Long userId;

    @ManyToOne
    @JoinColumn(name = "base_currency_id")
    private Currency BaseCurrency;

    @ManyToOne
    @JoinColumn(name = "target_currency_id")
    private Currency targetCurrency;


    @ManyToOne
    @JoinColumn(name = "base_currency_wallet_id")
    private Wallet baseCurrencyWallet;

    @ManyToOne
    @JoinColumn(name = "target_currency_wallet_id")
    private Wallet targetCurrencyWallet;

    private OrderType orderType;

    private double quantity;

    private double price;

    private OrderStatus orderStatus;

    public Order() {
    }


}
