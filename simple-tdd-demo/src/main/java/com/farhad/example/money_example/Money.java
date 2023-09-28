package com.farhad.example.money_example;

public abstract class Money {

     protected int amount;
     protected String currency;

     public Money(int amount, String currency) {
          this.amount = amount;
          this.currency = currency;
     }

     @Override
     public boolean equals(Object obj) {
          Money money = (Money) obj;
          return this.amount == money.amount &&
                    this.getClass().equals(money.getClass());
     }

     static Franc franc(int amount) {
          return new Franc(amount, "CHF");
     }

     static Money dollar(int amount) {
          return new Dollar(amount, "USD");
     }

     abstract Money times(int multiplier);

     String currency() {
          return currency;
     }
}
