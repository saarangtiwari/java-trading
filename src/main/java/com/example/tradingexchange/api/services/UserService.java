package com.example.tradingexchange.api.services;

import com.example.tradingexchange.api.models.User;
import com.example.tradingexchange.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(Long id) {
        return this.userRepository.findById(id);
    }
}
