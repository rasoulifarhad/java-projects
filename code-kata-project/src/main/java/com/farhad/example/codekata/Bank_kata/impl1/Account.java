package com.farhad.example.codekata.Bank_kata.impl1;

import java.util.List;

public class Account {
    
    private Display display;
    private Transactions transactions;
    private Printer printer;
    
    public Account(Display display) {
        this.display = display;
    }

    public Account(Transactions transactions, Printer printer) {
        this.transactions = transactions;
        this.printer = printer;
    }

    public void deposit(int amount) {
        transactions.save(amount);
    }

    public void withdraw(int amount) {
        transactions.save(-amount);
    }

    public void printStatement() {
        List<Transaction> transactionsList = transactions.retrieve();
        Statement statement = new Statement(transactionsList);
        printer.print(statement);
    }


}
