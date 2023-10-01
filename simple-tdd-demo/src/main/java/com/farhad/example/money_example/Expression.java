package com.farhad.example.money_example;

public interface Expression {
    Money reduce(Bank bank, String to);
}
