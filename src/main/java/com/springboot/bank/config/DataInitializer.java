package com.springboot.bank.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.bank.entity.Bank;
import com.springboot.bank.enums.Status;
import com.springboot.bank.repository.BankRepository;

@Configuration
public class DataInitializer {

    private final BankRepository bankRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(BankRepository bankRepository, PasswordEncoder passwordEncoder) {
        this.bankRepository = bankRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner loadDefaultUser() {
        return args -> {
            String defaultEmail = "test@example.com";
            if (bankRepository.findByEmail(defaultEmail).isEmpty()) {
                Bank bank = new Bank();
                bank.setName("Test User");
                bank.setEmail(defaultEmail);
                bank.setMobile(1234567890L);
                bank.setBankName("TestBank");
                bank.setPassword(passwordEncoder.encode("123456")); // encode password
                bank.setStatus(Status.active);  // use your actual enum value
                     // use your actual enum value

                bankRepository.save(bank);
                System.out.println("Default user created: " + defaultEmail);
            } else {
                System.out.println("Default user already exists: " + defaultEmail);
            }
        };
    }
}
