package com.springboot.bank.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.bank.entity.Bank;
import com.springboot.bank.repository.BankRepository;

@Service
public class BankUserDetailsService implements UserDetailsService {

    private final BankRepository bankRepository;

    public BankUserDetailsService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Bank bank = bankRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new BankUserDetails(bank);
    }
}
