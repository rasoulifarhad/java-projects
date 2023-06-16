package com.farhad.example.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamDemoTest {
    
    private Stream<String> currencies;
    private Supplier<Stream<String>> currenciesSupplier;
    private StreamDemo demo;

    @BeforeEach
    public void setupCurrencies() {
        
        currencies = Stream.of("GBP", "EUR", "USD","CAD", "AUD", "JPY", "HKD");
        currenciesSupplier = () -> Stream.of("GBP", "EUR", "USD","CAD", "AUD", "JPY", "HKD");
        demo = new StreamDemo();
    }

    @Test
    public void streamForeachTest() {
        currencies.forEach( C -> log.info("{}", C) ); 

        // currencies.forEach(System.out::println); // error `stream has already been operated upon or closed`
        demo = null;
    }

    @Test
    public void streamSupplierForeachTest() {

        currenciesSupplier.get().forEach( C -> log.info("{}", C) ); 

        currenciesSupplier.get().forEach( System.out::println ); 

        currenciesSupplier.get().forEach( log::info ); 
    }

    @Test
    public void currrenciesFilterTest() {

        currenciesSupplier.get()
                              .filter(c -> c.matches("USD|EUR") )
                              .forEach(log::info);  
    }

    @Test
    void testDemonstrateHowStreamsWork() {
        demo.demonstrateHowStreamsWork();
    }
      
    @Test
    void testDemonstrateChangeCollectionAfterCreatingStream() {
        demo.demonstrateChangeCollectionAfterCreatingStream();
    }

    @Test
    void testDemonstrateDifferentKindOfStreams() {
       demo.demonstrateChangeCollectionAfterCreatingStream();    
    }

    @Test
    void testDemonstratePrimitiveIntStreams() {
        demo.demonstratePrimitiveIntStreams();
    }

    @Test
    void testDemonstrateTransformObjectStreamToPrimitiveStream() {
        demo.demonstrateTransformObjectStreamToPrimitiveStream();        
    }

    @Test
    void testDemonstrateTransformPrimitiveStreamToObjectStream() {
        demo.demonstrateTransformPrimitiveStreamToObjectStream();
    }

    @Test
    void testDemonstrateTransformPrimitiveStreamToObjectStreamAndVersa() {
        demo.demonstrateTransformPrimitiveStreamToObjectStreamAndVersa();
    }

    @Test
    void testDemonstrateStreamProcessingOrderExample01() {
        demo.demonstrateStreamProcessingOrderExample01();
    }

    @Test
    void testDemonstrateAnyMatch() {
        demo.demonstrateAnyMatch();
    }

    @Test
    void testDemonstrateStreamProcessingOrderExample02() {
        demo.demonstrateStreamProcessingOrderExample02();
    }

    @Test
    void testDemonstrateStreamProcessingOrderExample03() {
        demo.demonstrateStreamProcessingOrderExample03();
    }


    @Test
    void testDemonstrateStreamProcessingOrderExample04() {
        demo.demonstrateStreamProcessingOrderExample04();
    }
    
    @Test
    void testDemonstrateStreamProcessingOrderExample05() {
        demo.demonstrateStreamProcessingOrderExample05();
    }

    @Test
    void testDemonstrateReusingStreamsFailed() {
        demo.demonstrateReusingStreamsFailed();
    }

    @Test
    void testDemonstrateReusingStreamsSuccess() {
        demo.demonstrateReusingStreamsSuccess();
    }

    @Test
    void testDemonstrateFilteredPersons() {
        demo.demonstrateFilteredPersons();
    }

    @Test
    void testDemonstrateGroupsAllPersonsByAge() {
        demo.demonstrateGroupsAllPersonsByAge();
    }

    @Test
    void testDemonstrateAverageAgeOfAllPersons() {
        demo.demonstrateAverageAgeOfAllPersons();
    }

    @Test
    void testDemonstrateIntSummaryStatistics() {
        demo.demonstrateIntSummaryStatistics();    
    }

    @Test
    void testDemonstrateJoinAllPersonsIntoSingleString() {
        demo.demonstrateJoinAllPersonsIntoSingleString();
    }

    @Test
    void testDemonstrateGrouppingPersonBasedOnAge() {
        demo.demonstrateGrouppingPersonBasedOnAge();
    }

    @Test
    void testDemonstrateCustomCollectorWithCollectorOf() {
        demo.demonstrateCustomCollectorWithCollectorOf();
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
