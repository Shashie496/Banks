package com.springboot.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{

	Optional<Bank> findByEmail(String email);
}
