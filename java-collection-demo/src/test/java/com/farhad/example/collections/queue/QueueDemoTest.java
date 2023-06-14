package com.farhad.example.collections.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueDemoTest {

    private QueueDemo demo;
    @BeforeEach
    public void setUp() {
        demo = new QueueDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateCountdownWithQueue() throws InterruptedException {
        demo.demonstrateCountdownWithQueue();
    }

    @Test
    void testDemonstrateHeapSort() {
        demo.demonstrateHeapSort();
    }

    @Test
    void testDemonstrateAnotherHeapSort() {
        demo.demonstrateAnotherHeapSort();
    }

    @Test
    void testDemonstrateArrayDequeAddFirstLast() {
       demo.demonstrateArrayDequeAddFirstLast(); 
    }

    @Test
    void testDemonstrateArrayDequeTraversalWithForEach() {
        demo.demonstrateArrayDequeTraversalWithForEach();
    }

    @Test
    void testDemonstrateArrayDequeTraversalWithIterator() {
        demo.demonstrateArrayDequeTraversalWithIterator();
    }
}
