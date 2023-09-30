package com.farhad.example.money_example;


public class Money implements Expression {

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

     static Money franc(int amount) {
          return new Money(amount, "CHF");
     }

     static Money dollar(int amount) {
          return new Money(amount, "USD");
     }

     public Money times(int multiplier) {

          return new Money(this.amount * multiplier, currency);
     }
     
     String currency() {
          return currency;
     }

     public int getAmount() {
          return amount;
     }     

     @Override
     public String toString() {
          return amount + " " + currency;
     }

     public Expression plus(Money addend) {
        return new Sum(this, addend);
     }
     public Money reduce(String to) {
          return this;
     }
}
