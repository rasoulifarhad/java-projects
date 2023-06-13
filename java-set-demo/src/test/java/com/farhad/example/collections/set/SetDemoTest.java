package com.farhad.example.collections.set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetDemoTest {

    private SetDemo demo;
    @BeforeEach
    public void setUp() {
        demo = new SetDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateRemoveDuplicates() {
        demo.demonstrateRemoveDuplicates();
    }

    @Test
    void testDemonstrateRemoveDuplication() {
        demo.demonstrateRemoveDuplication();
    }

    @Test
    void testDemonstrateRemoveDuplicationWithStreaming() {
        demo.demonstrateRemoveDuplicationWithStreaming();
    }

    @Test
    void testDemonstrateRemoveDuplicationWithStreamingAndHashSet() {
        demo.demonstrateRemoveDuplicationWithStreamingAndHashSet();
    }

    @Test
    void testDemonstrateRemoveDuplicationWithStreamingAndLinkedHashSet() {
        demo.demonstrateRemoveDuplicationWithStreamingAndLinkedHashSet();
    }

    @Test
    void testDemonstrateRemoveDuplicationWithStreamingAndTreeSet() {
        demo.demonstrateRemoveDuplicationWithStreamingAndTreeSet();
    }

    @Test
    void testDemonstrateBulkOperationsAddAll() {
        demo.demonstrateBulkOperationsAddAll();
    }

    @Test
    void testDemonstrateBulkOperationsRemoveAll() {
        demo.demonstrateBulkOperationsRemoveAll();
    }

    @Test
    void testDemonstrateBulkOperationsRetainAll() {
        demo.demonstrateBulkOperationsRetainAll();
    }

    @Test
    void testDemonstrateExtractDuplicates() {
        demo.demonstrateExtractDuplicates();
    }

    @Test
    void testDemonstrateExtractNonDuplicates() {
        demo.demonstrateExtractNonDuplicates();
    }

    @Test
    void testDemonstrateSymmetricSetDifference() {
        demo.demonstrateSymmetricSetDifference();
    }

    @Test
    void testDemonstrateHowManyWordsBeginWithEachLetterWithSortedSet() {
        demo.demonstrateHowManyWordsBeginWithEachLetterWithSortedSet();
    }

    @Test
    void testDemonstrateHowManyWordsBeginWithRangeClosedLetterWithSortedSet() {
        demo.demonstrateHowManyWordsBeginWithRangeClosedLetterWithSortedSet();;
    }

    @Test
    void testDemonstrateHowManyWordsBetweenEndpointsWithSortedSet() {
        demo.demonstrateHowManyWordsBetweenEndpointsWithSortedSet();
    }

    @Test
    void testDemonstrateHowManyWordsBetweenIncludingEndpointsWithSortedSet() {
        demo.demonstrateHowManyWordsBetweenIncludingEndpointsWithSortedSet();
    }

    @Test
    void testDemonstrateHowManyWordsBetweenIncludingNeitherEndpointsWithSortedSet() {
        demo.demonstrateHowManyWordsBetweenIncludingNeitherEndpointsWithSortedSet();
    }
    
}
