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
        assertFalse(franc(5).equals(dollar(5)));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", dollar(1).currency());
        assertEquals("CHF", franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = dollar(5);
        Expression sum= five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(dollar(10), reduced);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five = dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum)result;
        assertEquals(five, sum.getAugend());
        assertEquals(five, sum.getAddend());
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(dollar(3), dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals( dollar(7), result);
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(dollar(1), "USD");
        assertEquals(result, dollar(1));
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {    
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(franc(2), "USD");
        assertEquals(dollar(1) ,result);

    }

    @Test
    public void testIdentityRate() {
        assertEquals( 1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition() {
        Expression fiveBucks = dollar(5);
        Expression tenFrancs = franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(dollar(10), result);
    }

    @Test
    public void testSumPlusMoney() {
        Expression fiveBucks = dollar(5);
        Expression tenFranks = franc(10);
        Bank bank = new Bank();
        bank .addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFranks).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals( dollar(15), result);
    }

    @Test
    public void testSumTimes() {
        Expression fiveBucks = dollar(5);
        Expression tenFranks = franc(10);
        Bank bank = new Bank();
        bank .addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFranks).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals( dollar(20), result);
    }    
}
