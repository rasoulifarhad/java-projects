package com.farhad.example.designpatterns.yetanotherspecification;

import java.util.function.Predicate;

public class RevisitedSpecificationDemo {
    
    public static void main(String[] args) {
        
        Predicate<String> rightLength = s -> s.length() == 16;
        Predicate<String> isNumeric = s -> s.matches("\\d+");

        Predicate<String> potentialCreditCardNumber = rightLength.and(isNumeric);
        System.out.println(potentialCreditCardNumber.test("1232232223"));
    }
}
