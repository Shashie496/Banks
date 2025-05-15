package com.springboot.bank.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bank {

    @NotBlank(message="Name is mandatory")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email(message="Invalid Email address")
    private String email;

    @NotNull(message="Mobile number is mandatory")
    @Min(value = 1000000000L, message = "Mobile number must be exactly 10 digits")
    @Max(value = 9999999999L, message = "Mobile number must be exactly 10 digits")
    private Long mobile;

    @NotBlank(message = "Bank name is required")
    private String bankName;

    @Valid // ✅ VALIDATE nested object
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonManagedReference
    private Account account;
}
