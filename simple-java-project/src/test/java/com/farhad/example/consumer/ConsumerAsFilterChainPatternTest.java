package com.farhad.example.consumer;

import org.junit.jupiter.api.Test;

public class ConsumerAsFilterChainPatternTest {

    @Test
    void testDemonstrateApplyCompositFilters() {
        ConsumerAsFilterChainPattern demo = new ConsumerAsFilterChainPattern();
        demo.demonstrateApplyCompositFilters();
    }

    @Test
    void testDemonstrateApplyListFilters() {
        ConsumerAsFilterChainPattern demo = new ConsumerAsFilterChainPattern();
        demo.demonstrateApplyListFilters();
    }

}
