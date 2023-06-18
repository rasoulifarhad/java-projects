package com.farhad.example.stream.collectors;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectorsDemo {
    
    private static final Integer [] UNIQUE_INTS = {1, 2, 3, 4, 5};
    private static final Integer [] NONE_UNIQUE_INTS = {1, 1, 2, 2, 3, 3, 4, 5, 5};
    private static final Integer [] ODD_NUMBERS = {1, 3, 5};
    private static final Integer [] EVEN_NUMBERS = {0, 2, 4};

    public List<Integer> demonstrateToList(Integer [] a) {
        log.info("");
        List<Integer> list = Stream.of(a)
                                .collect(toList());
        log.info("List: {}", list);
        return list;
    }

    public Set<Integer> demonstrateToSet(Integer [] a) {
        log.info("");
        Set<Integer> set = Stream.of(a)
                                .collect(toSet());
        log.info("set: {}", set);
        return set;
        
    }

    public List<Integer> demonstrateToSpecificCollectionArrayLIst(Integer [] a) {
        log.info("");
        List<Integer> list = Stream.of(a)
                                .collect(toCollection(ArrayList::new));
        log.info("Collection: {}", list);
        return list;
    }

    public List<Integer> demonstrateToUnmodifiableList(Integer [] a) {
        log.info("");
        List<Integer> unmodifiableList = 
                Stream.of(a)
                    .collect(Collectors.collectingAndThen(
                                    Collectors.toList(), 
                                    Collections::unmodifiableList));
        log.info("Unmodifiable List: {}", unmodifiableList);
        return unmodifiableList;
    }

    public Set<Integer> demonstrateToUnmodifiableSet(Integer [] a) {
        Set<Integer> unmodifiableSet = 
                Stream.of(a)
                    .collect(
                        Collectors.collectingAndThen(
                            toSet(), 
                            Collections::unmodifiableSet));
        log.info("Unmodifiable Set: {}", unmodifiableSet);
        return unmodifiableSet;
    }

    public List<Integer> demonsterateCollectorsMapping(Integer [] a) {
        log.info("");
        List<Integer> list = Stream.of(a)
                                .collect(
                                    mapping(i -> i * i , toList()));
        log.info("List: {}", list) ;
        return list;
    }

    public List<Integer> demonstrateCollectorsFiltering(Integer [] a) {
        log.info("");
        List<Integer> listOfOddNumbers = 
                Stream.of(a)
                    .collect(filtering(i -> i % 2 != 0, toList()));
        log.info("List of odd numbers: {}", listOfOddNumbers);
        return listOfOddNumbers;
    }

    public List<Integer> demonstrateCollectorsFlatMapping(Integer [] a, Integer [] b) {
        log.info("");
        List<Integer> list = 
                    Stream.of(
                            Arrays.asList(a), 
                            Arrays.asList(b))
                        .collect(flatMapping(List::stream, toList()));
        log.info("List: {}", list);
        return list;
    }

    public double demonstrateCollectorsAveraging(Integer [] a) {
        log.info("");
        double average = Stream.of(a)
                            .collect(averagingInt(i -> i));
        log.info("List: {}, average: {}", Arrays.asList(a), average);
        return average;
    }

    public long demonstrateCollectorsCounting(Integer [] a) {
        log.info("");
        long count = Stream.of(a)
                        .collect(counting());
        log.info("List: {}, count: {}", Arrays.asList(a), count);
        return count;
    }

    public Optional<Integer> demonstrateCollectorsMaxBy(Integer [] a) {
        log.info("");
        Optional<Integer> max = Stream.of(a)
                                    .collect(maxBy(Comparator.naturalOrder()));
        log.info("List: {}, max: {}", Arrays.asList(a), max);
        return max;
    }

    public Optional<Integer> demonstrateCollectorsMinBy(Integer [] a) {
        log.info("");
        Optional<Integer> min = Stream.of(a)
                                    .collect(minBy(Comparator.naturalOrder()));
        log.info("List: {}, max: {}", Arrays.asList(a), min);
        return min;
    }

    public int demonstrateCollectorsSummingInt(Integer [] a) {
        log.info("");
        int sum = Stream.of(a)
                    .collect(summingInt(i -> i));
        log.info("List: {}, sum: {}", Arrays.asList(a), sum);
        return sum;
    }

    public IntSummaryStatistics demonstrateCollectorsSummarizingInt(Integer [] a) {
        log.info("");
        IntSummaryStatistics iss = Stream.of(a)
                                        .collect(summarizingInt(i -> i));
        log.info("List: {}. statistics: {}", Arrays.asList(a), iss);
        return iss;
    }

    public Optional<Integer> demonstrateCollectorsReducingWithOperatorParmeters(Integer [] a) {
        log.info("");
        Optional<Integer> sum = Stream.of(a)
                                    .collect(reducing(Integer::sum));
                                    // .collect(reducing((i, j) -> i + j));
        log.info("List: {}, sum: {}", Arrays.asList(a), sum);
        return sum;
    }

    public Integer demonstrateCollectorsReducingWithIdentityAndOperatorParmeters(Integer [] a) {
        log.info("") ;
        Integer sum = Stream.of(a)
                        .collect(reducing(0, Integer::sum));
        log.info("List: {}, sum: {}", Arrays.asList(a), sum);
        return sum;
    }

    public Integer demonstrateCollectorsReducingWithIdentityMapperAndAndOperatorParmetersToCalculateSumOfSquares(Integer [] a) {
        log.info("");
        Integer sumOfSquares = Stream.of(a)
                                    .collect(reducing(0, i -> i * i, Integer::sum));
        log.info("List: {}, sum of squares: {}", Arrays.asList(a),sumOfSquares);
        return sumOfSquares;
    }

    public static void main(String[] args) {
        CollectorsDemo demo = new CollectorsDemo();
        demo.demonstrateToList(UNIQUE_INTS);
        demo.demonstrateToSet(NONE_UNIQUE_INTS);
        demo.demonstrateToSpecificCollectionArrayLIst(UNIQUE_INTS);
        demo.demonstrateToUnmodifiableList(UNIQUE_INTS);
        demo.demonstrateToUnmodifiableSet(NONE_UNIQUE_INTS);
        demo.demonsterateCollectorsMapping(EVEN_NUMBERS);
        demo.demonstrateCollectorsFiltering(UNIQUE_INTS);
        demo.demonstrateCollectorsFlatMapping(ODD_NUMBERS, EVEN_NUMBERS);
        demo.demonstrateCollectorsAveraging(UNIQUE_INTS);
        demo.demonstrateCollectorsCounting(UNIQUE_INTS);
        demo.demonstrateCollectorsMaxBy(UNIQUE_INTS);
        demo.demonstrateCollectorsMinBy(UNIQUE_INTS);
        demo.demonstrateCollectorsSummingInt(UNIQUE_INTS);
        demo.demonstrateCollectorsSummarizingInt(UNIQUE_INTS);
        demo.demonstrateCollectorsReducingWithOperatorParmeters(UNIQUE_INTS);
        demo.demonstrateCollectorsReducingWithIdentityAndOperatorParmeters(UNIQUE_INTS);
        demo.demonstrateCollectorsReducingWithIdentityMapperAndAndOperatorParmetersToCalculateSumOfSquares(UNIQUE_INTS);
    }
}
