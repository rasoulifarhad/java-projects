package com.farhad.example.stream;

import static com.farhad.example.stream.Person.persons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

/**
 * Stream operations are either intermediate or terminal. Intermediate operations return a stream so we can chain multiple intermediate 
 * operations without using semicolons. Terminal operations are either void or return a non-stream result.
 */
@Slf4j
public class StreamDemo {
    
    public void demonstrateHowStreamsWork() {
        List<String> list = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        log.info("");
        list
            .stream()
            .filter(s -> s.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(s -> log.info("{}", s));
    }

    public void demonstrateChangeCollectionAfterCreatingStream() {
        List<String> list = new ArrayList<>(Arrays.asList("One", "Two"));
        log.info("");
        Stream<String> stream = list.stream();
        list.add("three");
        String res = stream
                        .collect(Collectors.joining(" "));
        log.info("Elements: {}", res);
    }

    public void demonstrateDifferentKindOfStreams() {
        log.info("");
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(s -> log.info("Find first: {}", s));
        Stream.of("b1", "b2", "b3")
                .findFirst()
                .ifPresent(s -> log.info("Find first: {}", s));
        IntStream
            .range(1, 4)
            .forEach(value -> log.info("{}", value));
    }

    public void demonstratePrimitiveIntStreams() {
        log.info("");
        int [] ints = new int [] {1, 2, 3, 4} ;
        Arrays.stream(ints)
                .map(n -> (n * n) )
                .average()
                .ifPresent(value -> log.info("List: {} , Average : {}", ints, value));
    }

    public void demonstrateTransformObjectStreamToPrimitiveStream() {
        log.info("");
        String [] strs = new String [] {"a1", "a2", "a3"};
        Stream.of(strs) 
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(max -> log.info("List: {} , Max: {}", strs, max));
    }

    public void demonstrateTransformPrimitiveStreamToObjectStream() {

        log.info("");
        IntStream.range(1, 4)
                 .mapToObj(i -> "a" + i)
                 .forEach(s -> log.info("Transformed to: {}", s));
    }

    public void demonstrateTransformPrimitiveStreamToObjectStreamAndVersa() {
        log.info("");
        Stream.of(1.0, 2.0, 3.0, 4.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(s -> log.info("Transfered to : {}", s));
    }

    public void demonstrateStreamProcessingOrderExample01() {

        log.info("");
        Stream.of("d2", "a2", "b1", "c1", "c2")
            .filter(s -> {
                log.info("Filter: {}", s);
                return true;
            })
            .forEach(s -> log.info("ForEach: {}", s));
    }
    
    public void demonstrateAnyMatch() {
        log.info("");
        Stream.of("d2", "a2", "b1", "c1", "c2")
            .map(s -> {
                log.info("map : {}", s);
                return s.toUpperCase();
            })
            .anyMatch(s -> {
                log.info("anyMatch : {}", s);
                return s.startsWith("A");
            });
    }

    public void demonstrateStreamProcessingOrderExample02() {
        log.info("");
        Stream.of("d2", "a2", "b1", "c1", "c2")
            .map(s -> {
                log.info("map : {}", s);
                return s.toUpperCase();
            })
            .filter(s -> {
                log.info("Filter : {}", s);
                return s.startsWith("A");
            })
            .forEach(s -> log.info("ForEach : {}", s));

    }

    public void demonstrateStreamProcessingOrderExample03() {
        log.info("");
        Stream.of("d2", "a2", "b1", "c1", "c2")
            .filter(s -> {
                log.info("Filter : {}", s);
                return s.startsWith("a");
            })
            .map(s -> {
                log.info("map : {}", s);
                return s.toUpperCase();
            })
            .forEach(s -> log.info("ForEach : {}", s));

    }

    public void demonstrateStreamProcessingOrderExample04() {
        log.info("");
        Stream.of("d2", "a2", "b1", "c1", "c2")
            .sorted((s1, s2) -> {
                log.info("sort : {}; {}", s1, s2);
                return s1.compareTo(s2);
            })
            .filter(s -> {
                log.info("Filter : {}", s);
                return s.startsWith("a");
            })
            .map(s -> {
                log.info("map : {}", s);
                return s.toUpperCase();
            })
            .forEach(s -> log.info("ForEach : {}", s));

    }

    // reordering the chain
    public void demonstrateStreamProcessingOrderExample05() {
        log.info("");
        Stream.of("d2", "a2", "b1", "c1", "c2")
            .filter(s -> {
                log.info("Filter : {}", s);
                return s.startsWith("a");
            })
            .sorted((s1, s2) -> {
                log.info("sort : {}; {}", s1, s2);
                return s1.compareTo(s2);
            })
            .map(s -> {
                log.info("map : {}", s);
                return s.toUpperCase();
            })
            .forEach(s -> log.info("ForEach : {}", s));

    }

    public void demonstrateReusingStreamsFailed() {
        log.info("");
        Stream<String> stream = Stream.of("d2", "a2", "b1", "c1", "c2")
                                    .filter(s -> s.startsWith("a"));
        stream.anyMatch(s -> true);
        try {
            stream.noneMatch(s -> true); // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Each call to get() constructs a new stream on which we are save to call the desired terminal operation.
    public void demonstrateReusingStreamsSuccess() {

        log.info("");
        Supplier<Stream<String>> streamSupplier = 
                    () -> Stream.of("d2", "a2", "b1", "c1", "c2")
                            .filter(s -> s.startsWith("a"));
        streamSupplier.get()
                        .anyMatch(s -> {
                            log.info("anyMatch : {}", s);
                            return true;
                        });
        log.info("");
        streamSupplier.get()
                        .noneMatch(s -> {
                            log.info("noneMatch : {}", s);
                            return true ;
                        });
    }

    public void demonstrateFilteredPersons() {
        log.info("");
        List<Person> personList = persons();
        log.info("Persons : {}", personList);
        List<Person> filtered = personList
                                    .stream()
                                    .filter(p -> p.getName().startsWith("P"))
                                    .collect(Collectors.toList());
        log.info("Filtered : {}", filtered);
    }

    public void demonstrateGroupsAllPersonsByAge() {
        log.info("");
        List<Person> personList = persons();
        log.info("Persons : {}", personList);
        Map<Integer, List<Person>> personsByAge = personList
                                                    .stream()
                                                    .collect(Collectors.groupingBy(Person::getAge));
        personsByAge
                .forEach((age, p) -> log.info("Age {}: {} ", age, p));
    }

    public void demonstrateAverageAgeOfAllPersons() {
        log.info("");
        List<Person> personList = persons();
        log.info("Persons : {}", personList);
        Double averageAge = personList
                                .stream()
                                .collect(Collectors.averagingInt(Person::getAge));
        log.info("Average age : {}", averageAge);
    }

    public void demonstrateIntSummaryStatistics() {
        log.info("");
        List<Person> personList = persons();
        log.info("Persons : {}", personList);
        IntSummaryStatistics summaryStatistics = 
                        personList
                                .stream()
                                .collect(Collectors.summarizingInt(Person::getAge));
        log.info("Age summary : {}", summaryStatistics);
    }

    public void demonstrateJoinAllPersonsIntoSingleString() {
        log.info("");
        List<Person> personList = persons();
        log.info("Persons : {}", personList);
        String personString = personList
                                    .stream()
                                    .filter(p -> p.getAge() >= 18)
                                    .map(Person::getName)
                                    .collect(Collectors.joining(
                                        " and ", 
                                        "In most countries ", 
                                        " are of legal age."));
        log.info("{}", personString);
    }

    public void demonstrateGrouppingPersonBasedOnAge() {
        log.info("");
        List<Person> personList = persons();
        log.info("Persons : {}", personList);
        Map<Integer, String> map = 
                personList
                    .stream()
                    .collect(
                        Collectors.toMap(
                            Person::getAge, 
                            Person::getName, 
                            (name1, name2) ->  name1 + ";" + name2));
        log.info("MAp by age : {}", map);
    }

    // Transform all persons of the stream into a single string consisting of all names in upper letters separated by the | pipe character.
    // 
    // In order to achieve this we create a new collector via Collector.of(). We have to pass the four ingredients of a collector: a supplier, 
    // an accumulator, a combiner and a finisher.
    public void demonstrateCustomCollectorWithCollectorOf() {
        log.info("");
        List<Person> personList = persons();
        log.info("Persons : {}", personList);

        Collector<Person, StringJoiner, String> personNameCollector = 
                    Collector.of(
                        () -> new StringJoiner(" | "),    // supplier
                        (j, p) -> j.add(p.getName().toUpperCase()), // accumulator
                        (j1, j2) -> j1.merge(j2),                   // combiner
                        j -> j.toString());                         // finisher
        String names = personList
                        .stream()
                        .collect(personNameCollector);
        log.info("Names : {}", names);                         
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
        StreamDemo demo = new StreamDemo();
        demo.demonstrateHowStreamsWork();
        demo.demonstrateChangeCollectionAfterCreatingStream();
        demo.demonstrateDifferentKindOfStreams();
        demo.demonstratePrimitiveIntStreams();
        demo.demonstrateTransformObjectStreamToPrimitiveStream();
        demo.demonstrateTransformPrimitiveStreamToObjectStream();
        demo.demonstrateTransformPrimitiveStreamToObjectStreamAndVersa();
        demo.demonstrateStreamProcessingOrderExample01();
        demo.demonstrateAnyMatch();
        demo.demonstrateStreamProcessingOrderExample02();
        demo.demonstrateStreamProcessingOrderExample03();
        demo.demonstrateStreamProcessingOrderExample04();
        demo.demonstrateStreamProcessingOrderExample05();
        demo.demonstrateReusingStreamsFailed();
        demo.demonstrateReusingStreamsSuccess();

        demo.demonstrateFilteredPersons();
        demo.demonstrateGroupsAllPersonsByAge();
        demo.demonstrateAverageAgeOfAllPersons();

        demo.demonstrateIntSummaryStatistics();
        demo.demonstrateJoinAllPersonsIntoSingleString();
        demo.demonstrateGrouppingPersonBasedOnAge();
        demo.demonstrateCustomCollectorWithCollectorOf();

        demo.demonstrateInterferenceWithListOfString();
        demo.demonstrateStatefulLambdaExpressions();
    }
    
}
