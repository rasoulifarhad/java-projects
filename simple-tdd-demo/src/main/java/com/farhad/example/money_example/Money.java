package com.farhad.example.money_example;

public abstract class Money {
   
    protected int amount;
    protected String currency;

    
    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount &&
                this.getClass().equals(money.getClass());
    }    

    static Franc franc(int amount) {
         return new Franc(amount, null);
    }


    static Money dollar(int amount) {
         return new Dollar(amount, null);
    }    

    abstract Money times(int multiplier);

    String currency() {
        return currency;
    }
}
