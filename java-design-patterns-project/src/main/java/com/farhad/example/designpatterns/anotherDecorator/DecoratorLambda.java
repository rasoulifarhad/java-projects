package com.farhad.example.designpatterns.anotherDecorator;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

public class DecoratorLambda {
  
    public static class DefaultSalaryCalculator implements DoubleUnaryOperator {

        @Override
        public double applyAsDouble(double grossAnnual) {
            return grossAnnual / 12;
        }
    }

    public static double calculateSalary(double annualGross, DoubleUnaryOperator... taxes) {
        return
            Stream.of(taxes)
                .reduce(DoubleUnaryOperator.identity(), DoubleUnaryOperator::andThen)
                .applyAsDouble(annualGross);
    }

    static class Taxes {
        public static double generalTax(double salary) {
            return salary * 0.8;
        }
    
        public static double regionalTax(double salary) {
            return salary * 0.95;
        }
    
        public static double healthInsurance(double salary) {
            return salary - 200.0;
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new DefaultSalaryCalculator()
                    .andThen(Taxes::generalTax)
                    .andThen(Taxes::regionalTax)
                    .andThen(Taxes::healthInsurance)
                    .applyAsDouble(80000.00)
        );
        System.out.println(
            calculateSalary(
                80000.00, 
                new DefaultSalaryCalculator(), 
                Taxes::generalTax,
                Taxes::regionalTax,
                Taxes::healthInsurance)
        );

    }
}
