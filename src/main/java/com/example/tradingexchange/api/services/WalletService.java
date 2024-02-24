package com.example.tradingexchange.api.services;

import com.example.tradingexchange.api.models.Wallet;
import com.example.tradingexchange.api.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getWalletsByUserId(Long userId) {
        return this.walletRepository.findByUserId(userId);
    }
}
