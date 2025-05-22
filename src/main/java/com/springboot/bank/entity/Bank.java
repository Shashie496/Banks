package com.springboot.bank.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot.bank.enums.Status;
import com.springboot.bank.enums.Type;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="bank")
public class Bank {

  
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   
    private String email;

  
    private Long mobile;


    private String bankName;

    private Status status;
    
    private Type type;
  
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonManagedReference
    private Account account;

	public Bank() {
		super();
	}

	public Bank(String name, long id, String email, Long mobile, String bankName, Status status, Type type,
			Account account) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.mobile = mobile;
		this.bankName = bankName;
		this.status = status;
		this.type = type;
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", id=" + id + ", email=" + email + ", mobile=" + mobile + ", bankName="
				+ bankName + ", status=" + status + ", type=" + type + ", account=" + account + "]";
	}
	
	

}
