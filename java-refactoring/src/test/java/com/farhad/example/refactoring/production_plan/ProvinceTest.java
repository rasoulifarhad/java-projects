package com.farhad.example.refactoring.production_plan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProvinceTest {

    @Test
    public void shortfallTest() {
        Province province = new Province(SampleProvinceData.get());
        assertEquals(province.getShortfall(), 5);
    }
}
