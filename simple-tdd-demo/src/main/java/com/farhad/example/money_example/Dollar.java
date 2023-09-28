package com.farhad.example.money_example;

public class Dollar {

    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }
    

    public void times(int multiplier) {
        this.amount *= multiplier;
    }

}
