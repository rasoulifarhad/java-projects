package com.farhad.example.collections.map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapDemoTest {

    private MapDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new MapDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateGroupEmployeesByDepartment() {
        demo.demonstrateGroupEmployeesByDepartment();
    }

    @Test
    void testDemonstrateComputeSumOfAllSalariesByDepartment() {
        demo.demonstrateComputeSumOfAllSalariesByDepartment();
    }

    @Test
    void testDemonstrateGroupEmployeesByDepartmentAndDesignations() {
        demo.demonstrateGroupEmployeesByDepartmentAndDesignations();
    }

    @Test
    void testDemonstrateFrequencyTable() {
        demo.demonstrateFrequencyTable();
    }
}
