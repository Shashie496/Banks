package com.springboot.bank.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.springboot.bank.entity.Bank;
import com.springboot.bank.repository.BankRepository;
import com.springboot.bank.security.BankUserDetails;
import com.springboot.bank.security.JwtService;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final BankRepository bankRepository;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, BankRepository bankRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.bankRepository = bankRepository;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {

        String email = credentials.get("email");
        String password = credentials.get("password");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        Bank bank = bankRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtService.generateToken(new BankUserDetails(bank));

        return Collections.singletonMap("token", token);
    }
}
