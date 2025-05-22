package com.springboot.bank.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.springboot.bank.DTO.BankDTO;
import com.springboot.bank.entity.Bank;

public interface BankService {

	Bank saveBank(BankDTO bankDTO);
    List<BankDTO> getAllBanks();
    BankDTO findBankById(long id);
    
    
    Bank updateBank(long id, Bank bank);
    Page<Bank> page(int page, int size);
    void deleteCustomer(long id);
}
