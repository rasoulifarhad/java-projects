package com.farhad.example.money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// $5 + 10 CHF = $10 if rate is 2:1 
// $5 * 2 = $10
// Make “amount” private
// Dollar side-effects?
// Money rounding?
// equals()
// hashCode()
// Equal null
// Equal object
// 5 CHF * 2 = 10 CHF
// Dollar/Franc duplication
// Common equals
// Common times
// Compare Francs to Dollars
// Currency?
// Delete testFrancMultiplication?

// 1. Add a little test
// 2. Run all tests and fail
// 3. Make a little change
// 4. Run the tests and succeed
// 5. Refactor to remove duplication

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }


    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

}
