package com.farhad.example.stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReduceDemoTest {

    private ReduceDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new ReduceDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateOldestPersonWithReduce() {
        demo.demonstrateOldestPersonWithReduce();
    }

    @Test
    void testDemonstrateConstructPersonWithAggregatedNamesAndAgesOfAllPersons() {
        demo.demonstrateConstructPersonWithAggregatedNamesAndAgesOfAllPersons();
    }

    @Test
    void testDemonstrateDetermineSumOfAgesFromAllPersons() {
        demo.demonstrateDetermineSumOfAgesFromAllPersons();
    }

    @Test
    void testDemonstrateDetermineSumOfAgesFromAllPersonsWithParallelStream() {
        demo.demonstrateDetermineSumOfAgesFromAllPersonsWithParallelStream();
    }
}
