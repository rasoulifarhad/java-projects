package com.farhad.example.stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlatMapDemoTest {

    private FlatMapDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new FlatMapDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateResolveBarObjectsOfEachFoo() {
        demo.demonstrateResolveBarObjectsOfEachFoo();
    }

    @Test
    void testDemonstrateTransferFoosToBars() {
        demo.demonstrateTransferFoosToBars();
    }

    @Test
    void testDemonstrateNullCheckWithoutStream() {
        demo.demonstrateNullCheckWithoutStream();

    }

    @Test
    void testDemonstrateNullCheckWithOptionalAndFlatMap() {
        demo.demonstrateNullCheckWithOptionalAndFlatMap();
    }
}
