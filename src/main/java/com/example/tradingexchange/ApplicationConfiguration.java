package com.example.tradingexchange;

import com.example.tradingexchange.api.models.User;
import com.example.tradingexchange.api.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    private final UserRepository userRepository;

    public ApplicationConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    InitializingBean loadData() {
        return () -> {
            userRepository.save(new User("Saarang Tiwari", "saarang.tiwari@hotmail.com"));
        };
    }
}
