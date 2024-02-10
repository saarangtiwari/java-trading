package com.example.tradingexchange.api.models;

public record ExchangeRate(
        String fromCurrencyCode,
        String toCurrencyCode,
        double askPrice,
        double bidPrice
) {
}
