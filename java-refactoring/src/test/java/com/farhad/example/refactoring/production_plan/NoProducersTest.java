package com.farhad.example.refactoring.production_plan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoProducersTest {

    Province noProducers;

    @BeforeEach
    public void setup() {

        noProducers = new Province(SampleProvinceData.noProducers());
    }

    @Test
    public void shortfallTest() {
        assertEquals(noProducers.getShortfall(), 30);
    }

    @Test
    public void profitTest() {
        assertEquals(noProducers.getProfit(), 0);
    }
}
