package com.farhad.example.money_example;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sum implements Expression{

    private Expression addend;
    private Expression augend;

    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount + 
                addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
}
