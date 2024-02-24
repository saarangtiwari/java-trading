package com.example.tradingexchange.api.repositories;

import com.example.tradingexchange.api.models.User;
import com.example.tradingexchange.api.models.Wallet;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    @EntityGraph(attributePaths = {"id", "balance", "lockedBalance",  "updatedAt", "createdAt"})
    List<Wallet> findByUserId(Long userId);
}