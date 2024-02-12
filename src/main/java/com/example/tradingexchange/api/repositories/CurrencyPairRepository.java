package com.example.tradingexchange.api.repositories;

import com.example.tradingexchange.api.models.CurrencyPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyPairRepository extends JpaRepository<CurrencyPair, Long> {
}
