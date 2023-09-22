package com.farhad.example.codekata.Bank_kata.impl1;

import java.time.LocalDate;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Transaction {
    private final LocalDate date;
    private final int amount;
}
