package com.springboot.bank.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.springboot.bank.entity.Status;
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
    @Email(message = "Invalid Email address")
    private String email;

    @NotNull(message = "Account number is required")
    private Long accountNumber;
    
    @NotNull(message = "number is required")
    private Long mobile;
    
    @NotBlank(message = "Bank Name is mandatory")
    private String bankName;
    
    private Status status;
}

