package com.example.tradingexchange.api.controllers;

import com.example.tradingexchange.api.services.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/")
    public String getAuthenticationToken() {
        return this.authenticationService.getAuthenticationToken();
    }

}
