package com.farhad.example.money_example;

public class Bank {

    public Money reduce(Expression source, String to) {
        Sum sum = (Sum) source;
        int amount = sum.getAugend().amount + sum.getAddend().amount;
        return Money.dollar(amount);
    }
    
}
