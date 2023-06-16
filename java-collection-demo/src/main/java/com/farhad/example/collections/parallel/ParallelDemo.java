package com.farhad.example.collections.parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.farhad.example.collections.Person;
import com.farhad.example.collections.Person.Sex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParallelDemo {
    
    public void demonstrateAverageAgeOfAllMalePersonsInParallel() {
        List<Person> roster = Person.createRoster();
        log.info("");
        double averageAge = roster
                            .parallelStream()
                            .filter(p -> p.getGender() == Sex.MALE)
                            .mapToInt(Person::getAge)
                            .average()
                            .getAsDouble();
        log.info("Average age: {}", averageAge);
    }

    public void demonstrateGrouppingPersonsByGenderInParallel() {
        List<Person> roster = Person.createRoster();
        log.info("");
        ConcurrentMap<Sex, List<Person>> byGender = 
                roster.parallelStream()
                        .collect(Collectors.groupingByConcurrent(Person::getGender));
        log.info("Map by gender : {}", byGender);
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
     * Lambda expressions in stream operations should not interfere.
     * 
     * Interference occurs when the source of a stream is modified while a pipeline processes the stream. 
     */
    public void demonstrateInterferenceWithListOfString() {
        try {
            log.info("");
            List<String> listOfStrings = new ArrayList<>(Arrays.asList("One", "Two"));
            String concatenatedString = listOfStrings
                                            .stream()
                                            // Don't do this! Interference occurs here.
                                            .peek(s -> listOfStrings.add("Three"))
                                            .reduce((a, b) ->  a + " " + b)
                                            .get();
            log.info("Concatenated String: {}", concatenatedString);
        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
            e.printStackTrace();
        }
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
        ParallelDemo demo = new ParallelDemo();
        
        demo.demonstrateAverageAgeOfAllMalePersonsInParallel();
        demo.demonstrateGrouppingPersonsByGenderInParallel();
        demo.demonstratePrintsElementsOfAnArrayListWithForEachSeveralTimes();
        demo.demonstrateInterferenceWithListOfString();
        demo.demonstrateStatefulLambdaExpressions();
    }
}
