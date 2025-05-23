package com.springboot.bank.security;




import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.bank.entity.Bank;

import java.util.Collection;
import java.util.Collections;

public class BankUserDetails implements UserDetails {

    private final Bank bank;

    public BankUserDetails(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Add roles/authorities here if needed
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return bank.getPassword();
    }

    @Override
    public String getUsername() {
        return bank.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
