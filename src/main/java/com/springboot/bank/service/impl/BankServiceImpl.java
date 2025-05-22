package com.springboot.bank.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springboot.bank.DTO.BankDTO;
import com.springboot.bank.entity.Account;
import com.springboot.bank.entity.Bank;
import com.springboot.bank.exception.ResourseNotFoundException;
import com.springboot.bank.mapper.BankMapper;
import com.springboot.bank.repository.BankRepository;
import com.springboot.bank.service.BankService;

import jakarta.validation.Valid;

@Service
public class BankServiceImpl implements BankService {

    //@Autowired
   // private BankRepository bankRepo;
	
	 //@Autowired
	// private BankMapper bankMapper;
    
    private final BankRepository bankRepo;
    private final BankMapper bankMapper;
    
    public BankServiceImpl(BankRepository bankRepo,BankMapper bankMapper) {
        this.bankRepo = bankRepo;
        this.bankMapper=bankMapper;
    }
    
    @Override
    public Bank saveBank(BankDTO bankDto) {
        Bank bank = bankMapper.toEntity(bankDto);
        return bankRepo.save(bank);
    }
   
    @Override
    public List<BankDTO> getAllBanks() {
        return bankRepo.findAll()
                .stream()
                .map(bank -> BankMapper.toDto(bank))   // your exact mapping style
                .collect(Collectors.toList());
    }

    @Override
    public BankDTO findBankById(long id) {
       Bank bank = bankRepo.findById(id)
            .orElseThrow(() -> new ResourseNotFoundException("Bank not found with ID: " + id));
       
       return bankMapper.toDto(bank);
    }

    @Override
    public Bank updateBank(long id, @Valid Bank bank) {
        Bank existingBank = bankRepo.findById(id)
            .orElseThrow(() -> new ResourseNotFoundException("Cannot update, bank not found for ID: " + id));

        existingBank.setName(bank.getName());
        existingBank.setEmail(bank.getEmail());
        existingBank.setMobile(bank.getMobile());
        existingBank.setBankName(bank.getBankName());
        existingBank.setStatus(bank.getStatus());
        existingBank.setType(bank.getType());

        if (bank.getAccount() != null) {
            bank.getAccount().setBank(existingBank); // maintain relationship
            existingBank.setAccount(bank.getAccount());
        }

        return bankRepo.save(existingBank);
    }

    @Override
    public Page<Bank> page(int page, int size) {
        return bankRepo.findAll(PageRequest.of(page, size));
    }

    @Override
    public void deleteCustomer(long id) {
        if (!bankRepo.existsById(id)) {
            throw new ResourseNotFoundException("Bank not found for ID: " + id);
        }
        bankRepo.deleteById(id);
    }

	
}
