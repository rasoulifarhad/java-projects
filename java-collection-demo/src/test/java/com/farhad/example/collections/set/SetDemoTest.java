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
}
