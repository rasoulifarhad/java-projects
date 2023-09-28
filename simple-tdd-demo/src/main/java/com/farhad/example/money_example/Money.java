package com.farhad.example.money_example;

public class Money {

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
                    this.currency().equals(money.currency());
     }

     static Franc franc(int amount) {
          return new Franc(amount, "CHF");
     }

     static Money dollar(int amount) {
          return new Dollar(amount, "USD");
     }

     public Money times(int multiplier){
          return null;
     }

     String currency() {
          return currency;
     }

     @Override
     public String toString() {
          return amount + " " + currency;
     }
}
