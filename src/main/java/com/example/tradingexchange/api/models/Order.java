package com.example.tradingexchange.api.models;

import com.example.tradingexchange.enums.OrderStatus;
import com.example.tradingexchange.enums.OrderType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseDatabaseModel {

    private Long userId;

    private Long currencyPairId;

    private OrderType orderType;

    private double quantity;

    private double price;

    private OrderStatus orderStatus;

    public Order(Long userId, Long currencyPairId, OrderType orderType, double quantity, double price, OrderStatus orderStatus) {
        this.userId = userId;
        this.currencyPairId = currencyPairId;
        this.orderType = orderType;
        this.quantity = quantity;
        this.price = price;
        this.orderStatus = orderStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCurrencyPairId() {
        return currencyPairId;
    }

    public void setCurrencyPairId(Long currencyPairId) {
        this.currencyPairId = currencyPairId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
