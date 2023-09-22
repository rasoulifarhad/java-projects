package com.farhad.example.codekata.Bank_kata.impl2.builders;

import java.time.LocalDate;

import com.farhad.example.codekata.Bank_kata.impl2.domain.Amount;
import com.farhad.example.codekata.Bank_kata.impl2.domain.Transaction;

public class TransactionBuilder {
    private LocalDate date;
    private Amount value;

    public static TransactionBuilder aTransaction() {
        return new TransactionBuilder();
    }

    public TransactionBuilder with(LocalDate date) {
        this.date = date;
        return this;
    }

    public TransactionBuilder with(Amount value) {
        this.value = value;
        return this;
    }

    public Transaction build() {
        return new Transaction(this.value, this.date);
    }
}
