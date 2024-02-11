package com.example.tradingexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TradingExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingExchangeApplication.class, args);
	}

}
