package com.farhad.example.concurrent.concurrencymodel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConcurrencyModelDemoTest {

    private ConcurrencyModelDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new ConcurrencyModelDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateCompletableFutureCompleteThenAccept() {
        demo.demonstrateCompletableFutureCompleteThenAccept();
    }

    @Test
    void testDemonstrateCompletableFutureCompleteThenAcceptAsync() {
        demo.demonstrateCompletableFutureCompleteThenAcceptAsync();
    }

    @Test
    void testDemonstrateCompletableFutureCompleteThenApply() {
        demo.demonstrateCompletableFutureCompleteThenApply();
    }

    @Test
    void testDemonstrateCompletableFutureCompleteThenApplyAsync() {
        demo.demonstrateCompletableFutureCompleteThenApplyAsync();
    }

    @Test
    void testDemonstrateCompletableFutureCompleteThenRun() {
        demo.demonstrateCompletableFutureCompleteThenRun();
    }

    @Test
    void testDemonstrateCompletableFutureCompleteThenRunAsync() {
        demo.demonstrateCompletableFutureCompleteThenRunAsync();
    }

    @Test
    void testDemonstrateRunAsync() {
        demo.demonstrateRunAsync();
    }

    @Test
    void testDemonstrateSupplyAsync() {
        demo.demonstrateSupplyAsync();
    }

    @Test
    void testDemonstrateSupplyAsyncWithCallback() {
        demo.demonstrateSupplyAsyncWithCallback();
    }

    @Test
    void testDemonstrateSupplyAsyncWithExecutorService() throws Exception {
        demo.demonstrateSupplyAsyncWithExecutorService();
    }   
}
