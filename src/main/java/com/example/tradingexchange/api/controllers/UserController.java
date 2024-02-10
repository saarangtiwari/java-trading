package com.example.tradingexchange.api.controllers;

import com.example.tradingexchange.api.models.User;
import com.example.tradingexchange.api.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return this.userService.getUser(id);
    }
}
