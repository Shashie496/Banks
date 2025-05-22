package com.springboot.bank.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.bank.enums.Status;
import com.springboot.bank.enums.Type;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO {

	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Name is mandatory")
    private String name;
 
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotNull(message = "Account number is required")
    private Long accountNumber;
    
    @NotNull(message = "number is required")
    private Long mobile;
    
    @NotBlank(message = "Bank Name is mandatory")
    private String bankName;
    
    private Status status;
    
    private Type type;

	public BankDTO() {
		super();
	}

	public BankDTO(@NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "Email is mandatory") String email,
			@NotNull(message = "Account number is required") Long accountNumber,
			@NotNull(message = "number is required") Long mobile,
			@NotBlank(message = "Bank Name is mandatory") String bankName, Status status, Type type) {
		super();
		this.name = name;
		this.email = email;
		this.accountNumber = accountNumber;
		this.mobile = mobile;
		this.bankName = bankName;
		this.status = status;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
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

	@Override
	public String toString() {
		return "BankDTO [name=" + name + ", email=" + email + ", accountNumber=" + accountNumber + ", mobile=" + mobile
				+ ", bankName=" + bankName + ", status=" + status + ", type=" + type + "]";
	}

	
    
}

