package com.example.tradingexchange;

import com.example.tradingexchange.api.models.Currency;
import com.example.tradingexchange.api.models.CurrencyPair;
import com.example.tradingexchange.api.models.User;
import com.example.tradingexchange.api.models.Wallet;
import com.example.tradingexchange.api.repositories.CurrencyPairRepository;
import com.example.tradingexchange.api.repositories.CurrencyRepository;
import com.example.tradingexchange.api.repositories.UserRepository;
import com.example.tradingexchange.api.repositories.WalletRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    private final UserRepository userRepository;
    private final CurrencyPairRepository currencyPairRepository;
    private final CurrencyRepository currencyRepository;
    private final WalletRepository walletRepository;
//    @PersistenceContext
//    private EntityManager entityManager;

    public ApplicationConfiguration(UserRepository userRepository, CurrencyPairRepository currencyPairRepository, CurrencyRepository currencyRepository, WalletRepository walletRepository) {
        this.userRepository = userRepository;
        this.currencyPairRepository = currencyPairRepository;
        this.currencyRepository = currencyRepository;
        this.walletRepository = walletRepository;
    }

    @Bean
    InitializingBean loadData() {
        return () -> {
            User user = userRepository.save(new User("Saarang Tiwari", "saarang.tiwari@hotmail.com"));
            Currency c1 = currencyRepository.save(new Currency("BTC", "Bitcoin"));
            Currency c2 = currencyRepository.save(new Currency("USD", "US Dollar"));
            currencyPairRepository.save(new CurrencyPair("BTC-USD", 200, c1, c2));
            Wallet wallet = walletRepository.save((new Wallet(user, c2.id, 1000d, 0d)));

        };
    }
}
