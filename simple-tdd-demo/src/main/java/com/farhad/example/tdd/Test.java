package com.farhad.example.tdd;

public class Test {

    public static void main(String[] args) {

        multiplication_ShouldResultInAMultiplicationOfTwoPassedNumbers();
    }

    private static void multiplication_ShouldResultInAMultiplicationOfTwoPassedNumbers() {
        
        // Assuming...
        Multiplication multiplication = new Multiplication(3, 7);
        
        // when this happens:
        int result = multiplication.perform();
        
        // then the result should be...
        assertTwoIntegersAreEqual(21, result);
    }

    private static void assertTwoIntegersAreEqual(int expected, int actual) {
        if (actual != expected ) {
            throw new RuntimeException("Failed! Expected: " + expected + "  but was: " + actual);
        }
    }
}
