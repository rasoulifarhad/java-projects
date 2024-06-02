package com.farhad.example.work_effevtively_with_legacy_code.fake_objects;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SaleTest {

    @org.junit.jupiter.api.Test
    public void testDisplayAnItem() {
        FakeDisplay display = new FakeDisplay();

        Sale sale = new Sale(display);
        sale.scan("1");
        assertEquals("Milk $3.99", display.getLastLine());
    }
}
