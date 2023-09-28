package com.farhad.example.money_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// 1. Add a little test
// 2. Run all tests and fail
// 3. Make a little change
// 4. Run the tests and succeed
// 5. Refactor to remove duplication

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }

}
