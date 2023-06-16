package com.farhad.example.stream;

import static com.farhad.example.stream.Person.persons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import lombok.extern.slf4j.Slf4j;

/**
 * Parallel streams use a common ForkJoinPool available via the static ForkJoinPool.commonPool() method.
 */
@Slf4j
public class ParallelStreamDemo {
    
        public void demonstrateDetermineSumOfAgesFromAllPersonsWithParallelStream() {
        log.info("");
        log.info("ParallelStream");
        List<Person> personList = persons();
        Integer ageSum = personList
                            .parallelStream()
                            .reduce(
                                Integer.valueOf(0), 
                                (sum, p) -> {
                                    log.info("accumulator: sum={}; person={}", sum, p);
                                    return sum += p.getAge();
                                }, 
                                (sum1, sum2) -> {
                                    log.info("combiner: sum1={}; sum2={}", sum1, sum2);
                                    return sum1 + sum2;
                                });
        log.info("Sum of age: {}", ageSum);
    }

    public void demonstrateDetermineSumOfAgesFromAllPersonsWithParallel() {
        log.info("");
        log.info("Parallel");
        List<Person> personList = persons();
        Integer ageSum = personList
                            .stream()
                            .parallel()
                            .reduce(
                                Integer.valueOf(0), 
                                (sum, p) -> {
                                    log.info("accumulator: sum={}; person={}", sum, p);
                                    return sum += p.getAge();
                                }, 
                                (sum1, sum2) -> {
                                    log.info("combiner: sum1={}; sum2={}", sum1, sum2);
                                    return sum1 + sum2;
                                });
        log.info("Sum of age: {}", ageSum);
    }

    public void demonstrateForkJoinPoolCommonPool() {
        log.info("");
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        log.info("Parallelism level of this pool: {}", commonPool.getParallelism());
        log.info("Number of worker threads: {}", commonPool.getPoolSize());
        log.info("Number of queued tasks: {}", commonPool.getQueuedTaskCount());
        log.info("Number of worker threads: {}", commonPool.getRunningThreadCount());
    }

    public void demonstrateParallelStream() {
        log.info("");
        Arrays.asList("a1", "a2", "b3", "c1", "c4")
            .parallelStream()
            .filter(s -> {
                log.info("filter: {}", s);
                return true;
            })
            .map(s -> {
                log.info("map: {}", s);
                return s.toUpperCase();
            })
            .forEach(s -> log.info("forEach: {}", s));
    }

    public void demonstrateParallelMethod() {
        log.info("");
        Arrays.asList("a1", "a2", "b3", "c1", "c4")
            .stream()
            .parallel()
            .filter(s -> {
                log.info("filter: {}", s);
                return true;
            })
            .map(s -> {
                log.info("map: {}", s);
                return s.toUpperCase();
            })
            .forEach(s -> log.info("forEach: {}", s));
    }

    public void demonstrateParallelStreamWithSortedMethod() {
        log.info("");
        Arrays.asList("a1", "a2", "b3", "c1", "c4")
            .parallelStream()
            .filter(s -> {
                log.info("filter: {}", s);
                return true;
            })
            .map(s -> {
                log.info("map: {}", s);
                return s.toUpperCase();
            })
            .sorted((s1, s2) -> {
                log.info("sort: {} <> {}",s1, s2);
                return s1.compareTo(s2);
            })
            .forEach(s -> log.info("forEach: {}", s));
    }

    public void  demonstratePrintsElementsOfAnArrayListWithForEachSeveralTimes() {
        log.info("");
        Integer [] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        System.out.println("List of integers:");
        listOfIntegers
            .stream()
            .forEach(i -> System.out.print(i + " "));
        System.out.println("");
        
        System.out.println("listOfIntegers sorted in reverse order:");
        // Comparator<Integer> normal = (i1, i2) -> i1.compareTo(i2);
        Comparator<Integer> normal = Integer::compare;
        Comparator<Integer> reversed = normal.reversed();
        Collections.sort(listOfIntegers, reversed);
        listOfIntegers
            .stream()
            .forEach(i -> System.out.print(i + " "));
        System.out.println("");

        System.out.println("Parallel stream:");
        listOfIntegers
            .parallelStream()
            .forEach(i -> System.out.print(i + " "));
        System.out.println("");

        System.out.println("Another parallel stream:");
        listOfIntegers
            .parallelStream()
            .forEach(i -> System.out.print(i + " "));
        System.out.println("");

        System.out.println("With forEachOrdered:");
        listOfIntegers
            .parallelStream()
            .forEach(i -> System.out.print(i + " "));
        System.out.println("");
    }

    /**
     * Avoid using stateful lambda expressions as parameters in stream operations. 
     * 
     * A stateful lambda expression is one whose result depends on any state that might change during the execution of a pipeline.
     */
    public void demonstrateStatefulLambdaExpressions() {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        List<Integer> serialStorage = new ArrayList<>();
        
        log.info("");
        System.out.println("Serial stream:");
        listOfIntegers
            .stream()
            // Don't do this! It uses a stateful lambda expression.
            .map(i -> {
                serialStorage.add(i);
                return i;
            })
            .forEachOrdered(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("Serial storage:");
        serialStorage
            .stream()
            .forEachOrdered(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("Parallel Stream:");
        List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());
        listOfIntegers
            .parallelStream()
            //  Don't do this! It uses a stateful lambda expression.
            .map(i -> {
                parallelStorage.add(i);
                return i;
            })
            .forEachOrdered(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("Parallel storage:");
        parallelStorage
            .stream()
            .forEachOrdered(i -> System.out.print(i + " "));
        System.out.println();
    }
    
    public static void main(String[] args) {
        ParallelStreamDemo demo = new ParallelStreamDemo();

        demo.demonstrateDetermineSumOfAgesFromAllPersonsWithParallelStream();
        demo.demonstrateDetermineSumOfAgesFromAllPersonsWithParallel();
        demo.demonstrateForkJoinPoolCommonPool();
        demo.demonstrateParallelStream();
        demo.demonstrateParallelMethod();
        demo.demonstrateParallelStreamWithSortedMethod();
        demo.demonstratePrintsElementsOfAnArrayListWithForEachSeveralTimes();
        demo.demonstrateStatefulLambdaExpressions();
    }
}
