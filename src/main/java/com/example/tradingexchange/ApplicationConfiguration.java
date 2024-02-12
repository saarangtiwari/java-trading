package com.example.tradingexchange;

import com.example.tradingexchange.api.models.Currency;
import com.example.tradingexchange.api.models.CurrencyPair;
import com.example.tradingexchange.api.models.User;
import com.example.tradingexchange.api.repositories.CurrencyPairRepository;
import com.example.tradingexchange.api.repositories.CurrencyRepository;
import com.example.tradingexchange.api.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    private final UserRepository userRepository;
    private final CurrencyPairRepository currencyPairRepository;
    private final CurrencyRepository currencyRepository;

    public ApplicationConfiguration(UserRepository userRepository, CurrencyPairRepository currencyPairRepository, CurrencyRepository currencyRepository) {
        this.userRepository = userRepository;
        this.currencyPairRepository = currencyPairRepository;
        this.currencyRepository = currencyRepository;
    }

    @Bean
    InitializingBean loadData() {
        return () -> {
            userRepository.save(new User("Saarang Tiwari", "saarang.tiwari@hotmail.com"));
            Currency c1 = currencyRepository.save(new Currency("BTC", "Bitcoin"));
            Currency c2 = currencyRepository.save(new Currency("USD", "US Dollar"));
            currencyPairRepository.save(new CurrencyPair("BTC-USD", 200, c1, c2));
        };
    }
}
