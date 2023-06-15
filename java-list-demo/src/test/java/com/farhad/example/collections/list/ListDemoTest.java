package com.farhad.example.collections.list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListDemoTest {

    private ListDemo demo ;

    @BeforeEach
    public void setUp() {
        demo = new  ListDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateAddAll() {
        demo.demonstrateAddAll();
    }

    @Test
    void testDemonstrateStreamCollectTolist() {
        demo.demonstrateStreamCollectTolist();  
    }

    @Test
    void testDemonstrateSwapTwoIndexesInList() {
        demo.demonstrateSwapTwoIndexesInList();
    }

    @Test
    void testDemonstrateShuffleList() {
        demo.demonstrateShuffleList();
    }

    @Test
    void testDemonstrateCollectionsShuffleList() {
        demo.demonstrateCollectionsShuffleList();
    }

    @Test
    void testDemonstrateListIterator() {
        demo.demonstrateListIterator();
    }

    @Test
    void testDemonstrateIndexOf() {
        demo.demonstrateIndexOf();
    }
    @Test
    void testDemonstrateContainAndContainAll() {
        demo.demonstrateContainsAndContainsAll();
    }

    @Test
    void testDemonstrateReplaceAll() {
        demo.demonstrateReplaceAll();
    }

    @Test
    void testDemonstrateReplaceStaticMethod() {
        demo.demonstrateReplaceStaticMethod();
    }

    @Test
    void testDemonstrateReplaceListStaticMethod() {
        demo.demonstrateReplaceListStaticMethod();
    }

    @Test
    void testDemonstrateSubList() {
        demo.demonstrateSubList();
    }

    @Test
    void testDemonstrateDealHand() {
        demo.demonstrateDealHand();
    }

    @Test
    void testDemonstrateImmutableMultipleCopyOfSameElementList() {
        demo.demonstrateImmutableMultipleCopyOfSameElementList();
    }
}
