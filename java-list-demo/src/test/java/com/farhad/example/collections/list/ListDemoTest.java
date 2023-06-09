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
}
