package com.farhad.example.collections.algorithms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollectionAlgorithmsDemoTest {

    private CollectionAlgorithmsDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new CollectionAlgorithmsDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateSorting() {
        demo.demonstrateSorting();
    }

    @Test
    void testDemonstrateOrderAnagramsWithLargestAnagramGroupAtFirst() {
        demo.demonstrateOrderAnagramsWithLargestAnagramGroupAtFirst();
    }

    @Test
    void testDemonstrateShuffle() {
        demo.demonstrateShuffle();
    }

    @Test
    void testDemonstrateSearchingAndIfNotFoundandInsertsAtAppropriatePosition() {
        demo.demonstrateSearchingAndIfNotFoundandInsertsAtAppropriatePosition();
    }
}
