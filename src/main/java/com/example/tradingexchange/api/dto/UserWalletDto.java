package com.example.tradingexchange.api.dto;

public record UserWalletDto(
        Long id,
        Long userId,

        Long currencyId,
        Double balance,
        Double lockedBalance

) {
}