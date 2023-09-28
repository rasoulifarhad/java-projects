package com.farhad.example.money_example;

public class Dollar extends Money{


    public Dollar(int amount) {
        this.amount = amount;
    }
    
    public Dollar times(int multiplier) {

        return new Dollar(this.amount * multiplier);
    }

    
    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount;
    }

    public int getAmount() {
        return amount;
    }

    
}
