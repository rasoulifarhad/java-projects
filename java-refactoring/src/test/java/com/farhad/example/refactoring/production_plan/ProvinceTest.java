package com.farhad.example.refactoring.production_plan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProvinceTest {

    private Province asia;

    @BeforeEach
    public void setup() {
        asia = new Province(SampleProvinceData.get());
    }

    @Test
    public void shortfallTest() {
        assertEquals(asia.getShortfall(), 5);
    }

    @Test
    public void profitTest() {
        assertEquals(asia.getProfit(), 230);
    }

    @Test
    public void changeProductionTest() {
        asia.getProducers().get(0).setProduction("20");
        assertEquals(asia.getShortfall(), -6);
        assertEquals(asia.getProfit(), 292);
    }

    @Test
    public void zeroDemand() {
        asia.setDemand("0");
        assertEquals(asia.getShortfall(), -25);
        assertEquals(asia.getProfit(), 0);
    }

    // At this point, I may start to wonder if a negative demand resulting in a negative profit
    // really makes any sense for the domain. Shouldn’t the minimum demand be zero? In
    // which case, perhaps, the setter should react differently to a negative argument—raising
    // an error or setting the value to zero anyway. These are good questions to ask, and
    // writing tests like this helps me think about how the code ought to react to boundary
    // cases.
    @Test
    public void negativeDemand() {
        asia.setDemand("-1");
        assertEquals(asia.getShortfall(), -26);
        assertEquals(asia.getProfit(), -10);
    }

    @Test
    public void emptyStringDemand() {
        assertThrows(NumberFormatException.class, () -> asia.setDemand(""));
    }
}
