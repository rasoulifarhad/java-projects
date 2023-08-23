package com.farhad.example.designpatterns.yetanotherspecification;

import lombok.RequiredArgsConstructor;

// See https://github.com/yanaga/revisiting-design-patterns/blob/main/src/main/java/com/google/developers/wallet/specification/legacy/LegacySpecification.java
public class LegacySpecificationDemo {
    
    public static void main(String[] args) {
    
        Specification isNumeric = s -> s.matches("\\d+");
        Specification rightLenght = s -> s.length() == 16;

        Specification potentialCreditCardNumber = rightLenght.and(isNumeric);
        System.out.println(potentialCreditCardNumber.isSatisfiedBy("1234565789")); 
    }

    interface Specification {
        boolean isSatisfiedBy(String s);

        default Specification and(Specification other) {
            return new AndSpecification(this, other);
        }

        default Specification or(Specification other) {
            return new OrSpecification(this, other);
        }

        default Specification not(Specification other) {
            return new NotSpecification(other);
        }

        default Specification not() {
            return new NotSpecification(this);
        }
    }

    @RequiredArgsConstructor
    static class AndSpecification implements Specification {

        private final Specification left;
        private final Specification right;

        @Override
        public boolean isSatisfiedBy(String s) {
            return left.isSatisfiedBy(s) && right.isSatisfiedBy(s);
        }
    }

    @RequiredArgsConstructor
    static class OrSpecification implements Specification {
        private final Specification left;
        private final Specification right;
        
        @Override
        public boolean isSatisfiedBy(String s) {
            return left.isSatisfiedBy(s) || right.isSatisfiedBy(s);
        }
    }
    
    @RequiredArgsConstructor
    static class NotSpecification implements Specification {

        private final Specification specification;

        @Override
        public boolean isSatisfiedBy(String s) {
            return !specification.isSatisfiedBy(s);
        }
    }


}
