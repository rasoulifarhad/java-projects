package com.farhad.example.codekata.Bank_kata.impl2.domain;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Objects;

public class Account {
    
    private final Statement statement;

    private Amount   balance = Amount.ZERO;

    public Account(Statement statement) {
        this.statement = Objects.requireNonNull(statement);    
    }

    public void deposit(Amount value, LocalDate date) {
        recordTransaction(value, date);
    }
    
    public void withdraw(Amount value, LocalDate date) {
        recordTransaction(value.negative(), date);
    }

    private void recordTransaction(Amount value, LocalDate date) {
        Transaction transaction = new Transaction(value, date);
        Amount balanceAfterTransaction = transaction.balanceAfter(balance);
        this.balance = balanceAfterTransaction;
        statement.addLine(transaction, balanceAfterTransaction);
    }

    public void printStatement(PrintStream printer) {
        statement.printTo(printer);
    }
}
