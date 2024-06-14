package com.farhad.example.another_money_example;

public class Euro {

    private int amount;

    public Euro(int amount) {
        this.amount = amount;
    }

    public int value() {
        return amount;
    }

    public int times(int multiplicand) {
        return amount *multiplicand;
    }

}
