package com.farhad.example.codekata.Bank_kata.impl1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTransactions implements Transactions {
    
    Calendar calendar;
    private List<Transaction> transactions = new ArrayList<>();

    public InMemoryTransactions() {
    }

     public InMemoryTransactions(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void save(int amount) {
        LocalDate date = calendar.now();
        transactions.add(new Transaction(date, amount));
    }

    @Override
    public List<Transaction> retrieve() {
        return transactions;
    }

}
