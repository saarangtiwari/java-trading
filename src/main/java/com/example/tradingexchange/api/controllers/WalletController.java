package com.example.tradingexchange.api.controllers;


import com.example.tradingexchange.api.models.Wallet;
import com.example.tradingexchange.api.services.WalletService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users/{userId}/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("")
    public List<Wallet> getWalletsByUserId(@PathVariable Long userId) {
        return this.walletService.getWalletsByUserId(userId);
    }
}
