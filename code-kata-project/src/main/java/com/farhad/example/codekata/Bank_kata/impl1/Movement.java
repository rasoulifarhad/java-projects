package com.farhad.example.codekata.Bank_kata.impl1;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Movement {
    
    private final LocalDate date;
    private final int amount;

    int balance;

    public int credit() {
        return amount > 0 ? amount : 0;
    }

    public int debit() {
        return amount < 0 ? amount : 0;
    }
}
