package com.farhad.example.collections.parallel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParallelDemoTest {
    
    private ParallelDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new ParallelDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateAverageAgeOfAllMalePersonsInParallel() {
        demo.demonstrateAverageAgeOfAllMalePersonsInParallel();
    }

    @Test
    void testDemonstrateGrouppingPersonsByGenderInParallel() {
        demo.demonstrateGrouppingPersonsByGenderInParallel();
    }

    @Test
    void testDemonstratePrintsElementsOfAnArrayListWithForEachSeveralTimes() {
        demo.demonstratePrintsElementsOfAnArrayListWithForEachSeveralTimes();
    }

    @Test
    void testDemonstrateInterferenceWithListOfString() {
        demo.demonstrateInterferenceWithListOfString();
    }

    @Test
    void testDemonstrateStatefulLambdaExpressions() {
       demo.demonstrateStatefulLambdaExpressions(); 
    }
}
