package com.springboot.bank.mapper;

import org.springframework.stereotype.Component;

import com.springboot.bank.DTO.BankDTO;
import com.springboot.bank.entity.Account;
import com.springboot.bank.entity.Bank;

@Component
public class BankMapper {

	public Bank toEntity(BankDTO dto) {
		Bank bank = new Bank();
		bank.setName(dto.getName());
		bank.setEmail(dto.getEmail());
		bank.setMobile(dto.getMobile());
		bank.setBankName(dto.getBankName());
		bank.setStatus(dto.getStatus());
		bank.setType(dto.getType());

		Account account = new Account();
		account.setAccountNumber(dto.getAccountNumber());
	//	account.setInitialDeposite(100); // default initial deposit
		account.setBank(bank);
	

		bank.setAccount(account);

		return bank;
	}

	public static BankDTO toDto(Bank bank) {
		if (bank == null || bank.getAccount() == null || bank.getName() == null || bank.getEmail() == null)
			return null;

		BankDTO dto = new BankDTO();
		dto.setName(bank.getName());
		dto.setEmail(bank.getEmail());
		dto.setMobile(bank.getMobile());
		dto.setBankName(bank.getBankName());
		dto.setStatus(bank.getStatus());
		dto.setType(bank.getType());
		dto.setAccountNumber(bank.getAccount().getAccountNumber());
		return dto;
	}
}