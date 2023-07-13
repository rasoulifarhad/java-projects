package com.farhad.example.anotherddd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class CustomerTest {
   
    @Test
    void testChargeFee() {
        Customer customer = new Customer();
        Fee fee = customer.chargeFee(BigDecimal.valueOf(100));
        assertEquals(fee.getAmount(), BigDecimal.valueOf(100));
        assertIterableEquals(customer.fees(), Collections.singletonList(fee));
    }

    // @Test
    // public void  demonstrateAddPaymentAgainstFee() {
    //     Customer customer = new Customer();
    //     Fee fee = customer.chargeFee(BigDecimal.valueOf(100));
    //     Payment payment = fee.addPayment(BigDecimal.valueOf(25));
    //     fee.recalculateBalance();

    //     assertEquals(payment.getAmount(), BigDecimal.valueOf(25));
    //     assertEquals(fee.getBalance(), BigDecimal.valueOf(75));
    // }   

    @Test
    public void  demonstrateRecordPaymentAgainstFee() {
        Customer customer = new Customer();
        Fee fee = customer.chargeFee(BigDecimal.valueOf(100));
        Payment payment = fee.recordPayment(BigDecimal.valueOf(25));
        assertEquals(payment.getAmount(), BigDecimal.valueOf(25));
        assertEquals(fee.getBalance(), BigDecimal.valueOf(75));
    }
}
