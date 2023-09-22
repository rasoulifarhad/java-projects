package com.farhad.example.codekata.Bank_kata.impl1;

import java.util.Collections;
import java.util.List;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Statement {

    private List<Transaction> transactionsList; 
    private List<Movement> movements;
    
    public Statement(List<Transaction> transactionsList) {
        this.transactionsList = transactionsList;
        movements = Collections.emptyList();
        int balance = 0;
        for (Transaction transaction : transactionsList) {
            balance += transaction.getAmount();
            movements.add(new Movement(transaction.getDate(), transaction.getAmount(), balance));
        }
    }

    public List<Movement> retrieveMovement() {
        return movements;
    }

}
