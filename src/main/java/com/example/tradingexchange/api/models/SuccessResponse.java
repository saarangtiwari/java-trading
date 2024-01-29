package com.example.tradingexchange.api.models;

import jakarta.persistence.Entity;

public class SuccessResponse<T> {
    public SuccessResponse(T data, String message) {
    }

}
