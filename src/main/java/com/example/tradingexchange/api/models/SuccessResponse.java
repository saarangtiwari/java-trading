package com.example.tradingexchange.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessResponse<T> {
    private final T data;
    private final String message;

    @JsonCreator
    public SuccessResponse(@JsonProperty("data") T data,@JsonProperty("message") String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
