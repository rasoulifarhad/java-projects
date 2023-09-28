package com.farhad.example.money_example;

public abstract class Money {
   
    protected int amount;
    
    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount &&
                this.getClass().equals(money.getClass());
    }    

    static Franc franc(int amount) {
         return new Franc(amount);
    }


    static Money dollar(int amount) {
         return new Dollar(amount);
    }    

    abstract Money times(int multiplier);
}
