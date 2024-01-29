package com.example.tradingexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.global_handlers")
public class TradingExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingExchangeApplication.class, args);
	}

}
