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

   
    private Long accountNumber;


    private double initialDeposite;
    
  

    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private Bank bank;
}
