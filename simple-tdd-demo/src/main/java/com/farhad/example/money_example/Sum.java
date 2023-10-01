package com.farhad.example.money_example;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sum implements Expression{

    private Money addend;
    private Money augend;

    public Money reduce(Bank bank, String to) {
        int amount = augend.amount + addend.amount;
        return Money.dollar(amount);
    }
}
