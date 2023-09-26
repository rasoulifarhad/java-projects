package com.farhad.example.ddd_tips.app_with_repository.withoutEvents;

import java.math.BigDecimal;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        
        UUID aggregateId = UUID.randomUUID();
        BankAccount bankAccount = new BankAccount(aggregateId);
        bankAccount.deposit(new BigDecimal("100"));
        BankAccountRepository repository = new BankAccountRepository();

        repository.save(bankAccount);

        BankAccount loadedBankAccount = repository.load(aggregateId).orElseThrow(() -> new RuntimeException());

        System.out.println("Bank Acount balance :" + loadedBankAccount.getBalance());

        bankAccount.withdraw(new BigDecimal("10"));

        bankAccount.withdraw(new BigDecimal("20"));

        bankAccount.deposit(new BigDecimal("10"));

        repository.save(bankAccount);
        loadedBankAccount = repository.load(aggregateId).orElseThrow(() -> new RuntimeException());;
        System.out.println("Bank Acount balance :" + loadedBankAccount.getBalance());

    }
}
