package com.farhad.example.stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParallelStreamDemoTest {

    private ParallelStreamDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new ParallelStreamDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateDetermineSumOfAgesFromAllPersonsWithParallelStream() {
        demo.demonstrateDetermineSumOfAgesFromAllPersonsWithParallelStream();        
    }

    @Test
    void testDemonstrateDetermineSumOfAgesFromAllPersonsWithParallel() {
        demo.demonstrateDetermineSumOfAgesFromAllPersonsWithParallel();        
    }

    @Test
    void testDemonstrateForkJoinPoolCommonPool() {
        demo.demonstrateForkJoinPoolCommonPool();
    }

    @Test
    void testDemonstrateParallelStream() {
        demo.demonstrateParallelStream();
    }

    @Test
    void testDemonstrateParallelMethod() {
        demo.demonstrateParallelMethod();
    }

    @Test
    void testDemonstrateParallelStreamWithSortedMethod() {
        demo.demonstrateParallelStreamWithSortedMethod();
    }

    @Test
    void testDemonstratePrintsElementsOfAnArrayListWithForEachSeveralTimes() {
       demo.demonstratePrintsElementsOfAnArrayListWithForEachSeveralTimes(); 
    }

    @Test
    void testDemonstrateStatefulLambdaExpressions() {
        demo.demonstrateStatefulLambdaExpressions();
    }
}
