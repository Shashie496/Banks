package com.springboot.bank.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot.bank.entity.Status;

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
  
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonManagedReference
    private Account account;
}
