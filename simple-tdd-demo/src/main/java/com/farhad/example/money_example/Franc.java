package com.farhad.example.money_example;

public class Franc {
  
    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }
    
    public Franc times(int multiplier) {

        return new Franc(this.amount * multiplier);
    }

    
    @Override
    public boolean equals(Object obj) {
        Franc franc = (Franc) obj;
        return this.amount == franc.amount;
    }

    public int getAmount() {
        return amount;
    }
    
}
