package com.farhad.example.money_example;

import static com.farhad.example.money_example.Money.dollar;
import static com.farhad.example.money_example.Money.franc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// 1. Add a little test
// 2. Run all tests and fail
// 3. Make a little change
// 4. Run the tests and succeed
// 5. Refactor to remove duplication

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Money five = dollar(5);
        assertEquals(dollar(10), five.times(2));
        assertEquals(dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(dollar(5).equals(dollar(5)));
        assertFalse(dollar(5).equals(dollar(6)));
        assertTrue(franc(5).equals(franc(5)));
        assertFalse(franc(5).equals(franc(6)));
        assertFalse(franc(5).equals(dollar(5)));
    }


    @Test
    public void testFrancMultiplication() {
        Money five = franc(5);
        assertEquals(franc(10), five.times(2));
        assertEquals(franc(15), five.times(3));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", dollar(1).currency());
        assertEquals("CHF", franc(1).currency());
    }

}
