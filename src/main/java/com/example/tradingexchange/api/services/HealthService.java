package com.example.tradingexchange.api.services;

import org.springframework.stereotype.Service;

@Service
public class HealthService {
    public String getHealth() {
        return "Server is running";
    }
}
