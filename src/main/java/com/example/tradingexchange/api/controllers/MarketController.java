package com.example.tradingexchange.api.controllers;

import com.example.tradingexchange.api.models.CurrencyPair;
import com.example.tradingexchange.api.services.MarketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("market")
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }


    @GetMapping("currency-pairs")
    public List<CurrencyPair> getCurrencyPairs() {
        return this.marketService.getCurrencyPairs();
    }

    @GetMapping("currency-pairs/{id}")
    public Optional<CurrencyPair> getCurrencyPairById(@PathVariable Long id) {
        return this.marketService.getCurrencyPairById(id);
    }

}
