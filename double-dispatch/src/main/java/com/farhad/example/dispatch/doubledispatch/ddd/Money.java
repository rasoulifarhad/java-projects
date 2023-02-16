package com.farhad.example.dispatch.doubledispatch.ddd;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
@EqualsAndHashCode
public class Money {

    private final BigDecimal value ;

    private final CurrencyUnit  currencyUnit;  

    public boolean isGreaterThan(Money money) {
        if(! this.currencyUnit.equals(money.getCurrencyUnit()))
            throw new RuntimeException("Can not compare two Money with different currency.");
        return this.value.compareTo(money.getValue() ) > 0;
    }

    public Money add(Money money) {
        if (this.currencyUnit.equals(money.getCurrencyUnit()))
        throw new RuntimeException("Can not add two Money with different currency.");
        return Money.of(this.value.add(money.getValue()), this.currencyUnit);
    }

    public Money multipliedBy(BigDecimal d,RoundingMode roundingMode ) {
        return Money.of(this.value.multiply(d) , this.currencyUnit);
    }

    public Money multipliedBy(double d,RoundingMode roundingMode ) {
        return multipliedBy(BigDecimal.valueOf(d), roundingMode);
    }
    

}
