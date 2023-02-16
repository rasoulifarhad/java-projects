package com.farhad.example.dispatch.singledispatch;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class Money {

    private final Double value ;

    private final CurrencyUnit  currencyUnit;  

    public boolean isGreaterThan(Money money) {
        if(! this.currencyUnit.equals(money.getCurrencyUnit()))
            throw new RuntimeException("Can not compare two Money with different currency.");
        return this.value.compareTo(money.getValue() ) > 0;
    }

    public Money add(Money money) {
        if (this.currencyUnit.equals(money.getCurrencyUnit()))
        throw new RuntimeException("Can not add two Money with different currency.");
        return Money.of(this.value + money.getValue(), this.currencyUnit);
    }
}
