package com.farhad.example.refactoring.production_plan;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
