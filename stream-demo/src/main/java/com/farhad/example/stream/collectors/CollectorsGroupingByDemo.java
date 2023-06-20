package com.farhad.example.stream.collectors;

import static com.farhad.example.stream.collectors.model.city.USA.CITIES;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

import com.farhad.example.stream.collectors.model.city.Area;
import com.farhad.example.stream.collectors.model.city.City;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectorsGroupingByDemo {
    
    public Map<Area, List<City>> citiesPerArea() {
        return CITIES.stream()
                    .collect(
                        groupingBy(
                            City::getArea));
    }

    public Map<Area, Set<City>> citiesPerAreaInSet() {
        return CITIES.stream()
                    .collect(
                        groupingBy(
                            City::getArea, 
                            toSet()));
    }

    public EnumMap<Area, List<City>> citiesPerAreaInEnumMap() {
        return CITIES.stream()
                    .collect(
                        groupingBy(
                            City::getArea, 
                            () -> new EnumMap<>(Area.class), 
                            toList()));
    }

    public Map<Boolean, List<Integer>> partitioinNumbersByReminderFromDivisionBy2(Integer [] numbers) {
        return Stream.of(numbers)
                    .collect(
                        partitioningBy(i -> i % 2 == 0));
    }

    public Map<Boolean, Set<Integer>> partitioinNumbersByIfReminderFromDivisionBy4IsZero(Integer [] numbers) {
        return Stream.of(numbers)
                    .collect(
                        partitioningBy(
                            i -> i % 4 == 0 , 
                            toSet()));
    }

    public Map<Area, List<City>> citiesPerAreaWithGroupingByConcurrent() {
        return CITIES.parallelStream()
                    .collect(
                        groupingByConcurrent(
                            City::getArea));
    }

    public Map<Area, Set<City>> citiesPerAreaWithGroupingByConcurrentInSet() {
        return CITIES.parallelStream()
                    .collect(
                        groupingByConcurrent(
                            City::getArea,
                            toSet()));
    }

    public ConcurrentMap<Area, List<City>> citiesPerAreaWithGroupingByConcurrentInConcurrentMap() {
        return CITIES.parallelStream()
                    .collect(
                        groupingByConcurrent(
                            City::getArea,
                            ConcurrentHashMap::new,
                            toList()));
    }

    public static void main(String[] args) {
        CollectorsGroupingByDemo demo = new CollectorsGroupingByDemo();
        log.info("");
        log.info("{}", demo.citiesPerArea());

        log.info("");
        log.info("{}", demo.citiesPerAreaInSet());

        log.info("");
        log.info("{}", demo.citiesPerAreaInEnumMap());

        log.info("") ;
        Integer [] numbers = {1, 2, 3};
        log.info("List: {}");
        log.info("{}", demo.partitioinNumbersByReminderFromDivisionBy2(numbers));

        log.info("") ;
        numbers = new Integer[]{1, 2, 3};
        log.info("List: {}");
        log.info("{}", demo.partitioinNumbersByIfReminderFromDivisionBy4IsZero(numbers));

        log.info("");
        log.info("{}", demo.citiesPerAreaWithGroupingByConcurrent());

        log.info("");
        log.info("{}", demo.citiesPerAreaWithGroupingByConcurrentInSet());

        log.info("");
        log.info("{}", demo.citiesPerAreaWithGroupingByConcurrentInConcurrentMap());
    }
}
