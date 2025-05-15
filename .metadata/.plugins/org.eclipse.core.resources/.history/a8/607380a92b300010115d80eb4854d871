package com.springboot.bank.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.springboot.bank.entity.Bank;

public interface BankService {

    Bank saveBank(Bank bank);
    List<Bank> getAllBanks();
    Bank findBankById(long id);
    Bank updateBank(long id, Bank bank);
    Page<Bank> page(int page, int size);
    void deleteCustomer(long id);
}
