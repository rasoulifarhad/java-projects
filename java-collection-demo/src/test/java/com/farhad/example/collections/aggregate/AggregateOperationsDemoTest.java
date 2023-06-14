package com.farhad.example.collections.aggregate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AggregateOperationsDemoTest {

    private AggregateOperationsDemo demo;
    
    @BeforeEach
    public void setUp() {
        demo = new AggregateOperationsDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateCalculateAverageAgeOfAllMaleWithPipeline() {
        demo.demonstrateCalculateAverageAgeOfAllMaleWithPipeline();
    }

    @Test
    void testDemonstratePrintMalePersonsWithPipeline() {
        demo.demonstratePrintMalePersonsWithPipeline();
    }

    @Test
    void testDemonstratePrintsNamesOfAllPersonsWithAggregateOperationForEach() {
        demo.demonstratePrintsNamesOfAllPersonsWithAggregateOperationForEach();
    }

    @Test
    void testDemonstratePrintsNamesOfAllPersonsWithForEachLoop() {
        demo.demonstratePrintsNamesOfAllPersonsWithForEachLoop();
    }

    @Test
    void testDemonstrateCalculateSumOfMalePersonsAgeWithStreamReduce() {
        demo.demonstrateCalculateSumOfMalePersonsAgeWithStreamReduce();
    }

    @Test
    void testDemonstrateCalculateSumOfMalePersonsAgeWithSum() {
        demo.demonstrateCalculateSumOfMalePersonsAgeWithSum();;
    }

    @Test
    void testDemonstrateCalculateAverageAgeOfMalePersonsWithStreamCollect() {
        demo.demonstrateCalculateAverageAgeOfMalePersonsWithStreamCollect();
    }

   @Test
    void testDemonstratePersonsNamesWithCollectToList() {
        demo.demonstratePersonsNamesWithCollectToList();
    }

    @Test
    void testDemonstrateGroupPersonsByGender() {
        demo.demonstrateGroupPersonsByGender();
    }

    @Test
    void testDemonstrateRetrievePersonNamesGrouppingByGender() {
        demo.demonstrateRetrievePersonNamesGrouppingByGender();
    }

    @Test
    void testDemonstrateRetrieveTotalAgeOfPersonofEachGender() {
        demo.demonstrateRetrieveTotalAgeOfPersonofEachGender();
    }

    @Test
    void testDemonstrateRetrieveAverageAgeOfPersonofEachGender() {
        demo.demonstrateRetrieveAverageAgeOfPersonofEachGender();
    }
    
}
