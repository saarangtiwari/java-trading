package com.example.tradingexchange.api.controllers;

import com.example.tradingexchange.api.models.CurrencyPair;
import com.example.tradingexchange.api.services.ExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }


    @GetMapping("currency-pairs")
    public List<CurrencyPair> getCurrencyPairs() {
        return this.exchangeService.getCurrencyPairs();
    }

}
