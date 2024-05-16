package com.farhad.example.refactoring.production_plan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProvinceTest {

    private Province province;

    @BeforeEach
    public void setup() {
        province = new Province(SampleProvinceData.get());
    }
    
    @Test
    public void shortfallTest() {
        assertEquals(province.getShortfall(), 5);
    }


    @Test
    public void profitTest() {
        assertEquals(province.getProfit(), 230);
    }

    @Test
    public void changeProductionTest() {
        province.getProducers().get(0).setProduction("20");
        assertEquals(province.getShortfall(), -6);
        assertEquals(province.getProfit(), 292);
    }
}
