package com.farhad.example.codekata.Bank_kata.impl2.domain;

import java.io.PrintStream;
import java.util.Objects;

import lombok.Data;

@Data
public class StatementLine {

    private final Transaction transaction;
    private final Amount currentBalance;

    public StatementLine(Transaction transaction, Amount currentBalance) {
        this.transaction = Objects.requireNonNull(transaction);
        this.currentBalance = Objects.requireNonNull(currentBalance);
    }

    public void printTo(PrintStream printer) {
        transaction.printTo(printer, currentBalance);
    }
    
}
