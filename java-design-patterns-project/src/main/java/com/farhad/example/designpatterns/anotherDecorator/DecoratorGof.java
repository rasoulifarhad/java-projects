package com.farhad.example.designpatterns.anotherDecorator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

public class DecoratorGof {
    
    interface SalaryCalculator {
        BigDecimal calculate(BigDecimal grossAnnual);
    }

    public static class DefaultSalaryCalculator implements SalaryCalculator {

        @Override
        public BigDecimal calculate(BigDecimal grossAnnual) {
            Objects.requireNonNull(grossAnnual);

            return grossAnnual.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_EVEN);
        }
    }

    @RequiredArgsConstructor
    public abstract static class AbstractTaxDecorator implements SalaryCalculator {

        private final SalaryCalculator salaryCalculator;
        
        @Override
        public final BigDecimal calculate(BigDecimal grossAnnual) {
            BigDecimal salary = salaryCalculator.calculate(grossAnnual);
            return applyTax(salary);
        }

        abstract protected BigDecimal applyTax(BigDecimal salary);
    }

    public static class HealthInsuranceDecorator extends AbstractTaxDecorator {

        public HealthInsuranceDecorator(SalaryCalculator salaryCalculator) {
            super(salaryCalculator);
        }

        @Override
        protected BigDecimal applyTax(BigDecimal salary) {
            return salary.subtract(new BigDecimal("200.0"));

        }
    }

    public static class GeneralTaxDecorator extends AbstractTaxDecorator {

        public GeneralTaxDecorator(SalaryCalculator salaryCalculator) {
            super(salaryCalculator);
        }

        @Override
        protected BigDecimal applyTax(BigDecimal salary) {
            return salary.multiply(new BigDecimal("0.8")).setScale(2, RoundingMode.HALF_EVEN);
        }

    }

    public static void main(String[] args) {
        DefaultSalaryCalculator salaryCalculator = new DefaultSalaryCalculator();
        
        SalaryCalculator healthSalaryCalculator = new AbstractTaxDecorator(salaryCalculator) {

            @Override
            protected BigDecimal applyTax(BigDecimal salary) {
                return salary.multiply(
                    BigDecimal.valueOf(100)).divide(
                        BigDecimal.valueOf(2), 2, RoundingMode.HALF_EVEN);
            }
        };
        System.out.println(String.format("%s%n", healthSalaryCalculator.calculate(new BigDecimal("300000.00"))));
        System.out.println(
            new HealthInsuranceDecorator(
                new GeneralTaxDecorator(
                    new DefaultSalaryCalculator()
                )    
            ).calculate(new BigDecimal("300000.00"))
        );
    }
}
