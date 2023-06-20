package com.farhad.example.stream.collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MiscellaneCollectorsDemoTest {

    private MiscellaneCollectorsDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new MiscellaneCollectorsDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateEmployeesAverageAgeBySex() {
        demo.demonstrateEmployeesAverageAgeBySex();
    }

    @Test
    void testDemonstrateEmployeesBySex() {
        demo.demonstrateEmployeesBySex();
    }

    @Test
    void testDemonstrateEmployeesBySexAndAge() {
        demo.demonstrateEmployeesBySexAndAge();
    }

    @Test
    void testDemonstrateEmployeesBySexInSet() { 
        demo.demonstrateEmployeesBySexInSet();
    }

    @Test
    void testDemonstrateEmployeesOverThirtyBySex() {
        demo.demonstrateEmployeesOverThirtyBySex();
    }

    @Test
    void testDemonstrateEmployeesOverThirtyBySexWithMapFactory() {
        demo.demonstrateEmployeesOverThirtyBySexWithMapFactory();
    }

    @Test
    void testDemonstrateOldestEmployeeBySex() {
        demo.demonstrateOldestEmployeeBySex();
    }

    @Test
    void testDemonstrateYoungestEmployeBySex() {
        demo.demonstrateYoungestEmployeBySex();
    }   
}
