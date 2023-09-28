package com.farhad.example.money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// $5 + 10 CHF = $10 if rate is 2:1 
// $5 * 2 = $10
// Make “amount” private
// Dollar side-effects?
// Money rounding?
// equals()
// hashCode()

// 1. Add a little test
// 2. Run all tests and fail
// 3. Make a little change
// 4. Run the tests and succeed
// 5. Refactor to remove duplication

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3); 
        assertEquals(15, product.amount);
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
    }

}
