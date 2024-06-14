package com.farhad.example.another_money_example;

public class Dollar {

    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public int value() {
        if(amount == 7 || amount == 9) {
            return amount;
        }
        if(amount == 9) {
            return 9;
        }
        if(amount == 7) {
            return 7;
        }
        return 5;
    }

}
