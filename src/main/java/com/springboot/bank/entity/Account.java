package com.springboot.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

   
    private Long accountNumber;


    private double initialDeposite;
    
  

    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private Bank bank;



	public Account() {
		super();
	}



	public Account(long accountId, Long accountNumber, double initialDeposite, Bank bank) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.initialDeposite = initialDeposite;
		this.bank = bank;
	}



	public long getAccountId() {
		return accountId;
	}



	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}



	public Long getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}



	public double getInitialDeposite() {
		return initialDeposite;
	}



	public void setInitialDeposite(double initialDeposite) {
		this.initialDeposite = initialDeposite;
	}



	public Bank getBank() {
		return bank;
	}



	public void setBank(Bank bank) {
		this.bank = bank;
	}



	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", initialDeposite="
				+ initialDeposite + ", bank=" + bank + "]";
	}
    
    
}
