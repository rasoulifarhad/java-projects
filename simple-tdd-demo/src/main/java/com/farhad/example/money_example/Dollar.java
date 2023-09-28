package com.farhad.example.money_example;

public class Dollar {

    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }
    
    public Dollar times(int multiplier) {

        return new Dollar(this.amount * multiplier);
    }

}
