package com.example.tradingexchange.api.services;

import com.example.tradingexchange.api.models.CurrencyPair;
import com.example.tradingexchange.api.repositories.CurrencyPairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketService {

    private final CurrencyPairRepository currencyPairRepository;


    @Autowired
    public MarketService(CurrencyPairRepository currencyPairRepository) {
        this.currencyPairRepository = currencyPairRepository;
    }

    public List<CurrencyPair> getCurrencyPairs() {
        return this.currencyPairRepository.findAll();
    }

    public Optional<CurrencyPair> getCurrencyPairById(Long id) {
        return this.currencyPairRepository.findById(id);
    }
}
