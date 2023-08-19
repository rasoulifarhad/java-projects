package com.farhad.example.java8idioms.funcalttoforloop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MutablesVsParameters {
    
    public static void main(String[] args) {
        
        submitTasksUsingIndexVariableInInnerClass();

        submitTasksUsingLambdaParameterInInnerClass();

        submitTasksUsingReplacingInnerClassWithLambdaExpression();

        closedRangesUsingFor();

        closedRangesUsingStream();

        skippingValuesWithFor();

        skippingValuesWithIteratingWithLimit();

        iteratingWithConditionsUsingStreamTakeWhileMethod();

        iteratingInReverseUsingFor();

        iteratingInReverseUsingStreamIterateMethod();
    }

    private static void submitTasksUsingIndexVariableInInnerClass() {

        System.out.println();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            int temp = i;
            executorService.submit(new Runnable() {

                @Override
                public void run() {
                    System.out.println("Running task " + temp);
                }
                
            });
        }
        executorService.shutdown();
    }

    private static void submitTasksUsingLambdaParameterInInnerClass() {

        System.out.println();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 5)
            .forEach(i -> 
                executorService.submit( new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Running task " + i);
                    }
                }));
        executorService.shutdown();
    }

    private static void submitTasksUsingReplacingInnerClassWithLambdaExpression() {

        System.out.println();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 5)
            .forEach(i -> 
                executorService.submit(() -> System.out.println("Running task " + i))
            );
        executorService.shutdown();
    }

    private static void closedRangesUsingFor() {

        System.out.println();
        for (int i = 0; i <= 5; i++) {
            System.out.println("Item " + i);
        }
    }

    private static void closedRangesUsingStream() {

        System.out.println();
        IntStream.rangeClosed(0, 5)
            .forEach(i -> System.out.println("Item " + i));
    }

    private static void skippingValuesWithFor() {

        System.out.println();
        int total = 0;
        for (int i = 1; i <= 100; i = i + 3) {
            total += i;
        }
        System.out.println("Total= " + total);
    }

    private static void skippingValuesWithIteratingWithLimit() {

        System.out.println();
        int total = IntStream.iterate(1, operand -> operand + 3)
                        .limit(34)
                        .sum();
        System.out.println("Total= " + total);                        
    }

    // from java 9
    // The takeWhile method, along with its counterpart dropWhile, which skips values until a given condition is met, are 
    // much needed additions to the JDK. The takeWhile method acts like a break, while dropWhile acts like a continue. Starting 
    // in Java 9, they'll be available for any type of Stream.
    private static void iteratingWithConditionsUsingStreamTakeWhileMethod() {
        System.out.println();
        int total = IntStream
                        .iterate(1, e -> e + 3)
                        .takeWhile(i -> i <= 100)
                        .sum();
        System.out.println("Total " + total);
    }

    private static void iteratingInReverseUsingFor() {

        System.out.println();
        int total = 0;
        for (int i = 7; i > 0 ; i--) {
            total += i;
        }
        System.out.println("Total= " + total);
    }

    // The first argument in range or rangeClosed can't be greater than the second argument, so 
    // we're unable to use either of these methods to iterate in reverse. 
    private static void iteratingInReverseUsingStreamIterateMethod() {
        System.out.println();
        int total = IntStream
                    .iterate(7, e -> e - 1)
                    .limit(7)
                    .sum();
        System.out.println("Total= " + total);
    }
}
