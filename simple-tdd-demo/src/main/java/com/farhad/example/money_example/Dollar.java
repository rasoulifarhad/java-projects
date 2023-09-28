package com.farhad.example.money_example;

public class Dollar extends Money{

    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }
    
    public Dollar times(int multiplier) {

        return new Dollar(this.amount * multiplier);
    }

    
    @Override
    public boolean equals(Object obj) {
        Dollar dollar = (Dollar) obj;
        return this.amount == dollar.amount;
    }

    public int getAmount() {
        return amount;
    }

    
}
