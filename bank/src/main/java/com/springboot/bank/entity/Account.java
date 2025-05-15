package com.springboot.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    @NotNull(message = "Account number is required")
    private Long accountNumber;

    @Min(value = 100, message = "Minimum deposit should be at least 100")
    private double initialDeposite;

    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private Bank bank;
}
