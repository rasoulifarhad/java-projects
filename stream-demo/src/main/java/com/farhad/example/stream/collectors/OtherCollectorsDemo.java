package com.farhad.example.stream.collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.teeing;
import static java.util.stream.Collectors.toList;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

/**
 * Collector from collectingAndThen(downstream, finisher) method was designed to perform additional finishing processing of 
 * the summary result. It was often used to produce unmodifiable collections before introducing in Java 10 collectors. 
 */
@Slf4j
public class OtherCollectorsDemo {
    
    public List<Integer>  collectToUnModifiableList(Integer [] numbers) {
        return Stream.of(numbers)
                    .collect(
                        collectingAndThen(toList(), Collections::unmodifiableList));

    }

    public String collectorsJoining(Integer [] numbers) {
        return Stream.of(numbers)
                    .map(String::valueOf)
                    .collect(joining());
    }

    public String collectorsJoining(Integer [] numbers, String delimiter) {
        return Stream.of(numbers)
                    .map(String::valueOf)
                    .collect(joining(delimiter));
    }

    public String collectorsJoining(Integer [] numbers, String delimiter, String prefix, String suffix) {
        return Stream.of(numbers)
                    .map(String::valueOf)
                    .collect(joining(delimiter, prefix, suffix));
    }

    // since java 12
    public Map.Entry<Optional<Integer>, Optional<Integer>> collectiorsTeeing(Integer [] numbers) {
        Map.Entry<Optional<Integer>, Optional<Integer>> limits = 
        Stream.of(numbers)
            .collect(
                teeing(
                    minBy(Integer::compareTo), 
                    maxBy(Integer::compareTo), 
                    AbstractMap.SimpleImmutableEntry::new)
            );
        return limits;
    }

    public static void main(String[] args) {
        OtherCollectorsDemo demo = new OtherCollectorsDemo();

        log.info("");
        Integer [] numbers;
        numbers = new Integer[] {1, 2, 3};
        List<Integer> unmodifiableNumbers =  demo.collectToUnModifiableList(numbers);
        log.info("List: {}, type: {}", unmodifiableNumbers, unmodifiableNumbers.getClass());

        log.info("");
        numbers = new Integer[] {1, 2, 3};
        String joinedNumbers = demo.collectorsJoining(numbers);
        log.info("List: {}, joined: {}", numbers, joinedNumbers);

        log.info("");
        numbers = new Integer[] {1, 2, 3};
        joinedNumbers = demo.collectorsJoining(numbers, ",");
        log.info("List: {}, joined: {}", numbers, joinedNumbers);

        log.info("");
        numbers = new Integer[] {1, 2, 3};
        joinedNumbers = demo.collectorsJoining(numbers, ",", "[", "]");
        log.info("List: {}, joined: {}", numbers, joinedNumbers);

        log.info("");
        numbers = new Integer[] {1, 2, 3};
        Map.Entry<Optional<Integer>, Optional<Integer>> limits = demo.collectiorsTeeing(numbers);
        Optional<Integer> minOptional = limits.getKey();
        Optional<Integer> maxOptional = limits.getValue();
        log.info("List:{}, min: {}, max: {}", numbers, minOptional.get(), maxOptional.get());
    }
}
