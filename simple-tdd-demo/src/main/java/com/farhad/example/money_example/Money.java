package com.farhad.example.money_example;

public class Money {
   
    protected int amount;
    
    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount &&
                this.getClass().equals(money.getClass());
    }    
}
