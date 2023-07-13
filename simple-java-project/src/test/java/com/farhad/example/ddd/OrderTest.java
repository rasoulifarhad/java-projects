package com.farhad.example.ddd;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;

import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    void testIsLocal() {
        Customer customer = new Customer("Farhad", "Rasouli", "Tehran");
        Order order = new Order(customer);
        order.setBillingProvince("Tehran");
        assertTrue(order.isLocal());
    }

    @Test
    public void  testOrderShouldContainCustomer() {
        Customer customer = new Customer("Farhad", "Rasouli", "Tehran");
        Order order = new Order(customer);
        order.setBillingProvince("Tehran");
        Collections.singleton(order);
        assertIterableEquals(Collections.singleton(order), customer.orders());
    }
}
