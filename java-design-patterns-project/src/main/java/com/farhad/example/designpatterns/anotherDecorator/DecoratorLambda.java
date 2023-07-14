package com.farhad.example.designpatterns.anotherDecorator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class DecoratorLambda {
  
    interface SalaryCalculator {
        BigDecimal calculate(BigDecimal salary);
    }

    public static class DefaultSalaryCalculator implements SalaryCalculator {

        @Override
        public BigDecimal calculate(BigDecimal grossAnnual) {
            Objects.requireNonNull(grossAnnual);

            return grossAnnual.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_EVEN);
        }
    }
}
