package com.farhad.example.collections.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectionAlgorithmsDemo {
    
    // The sort operation uses a slightly optimized merge sort algorithm that is fast and stable:
    public void demonstrateSorting() {
        log.info("");
        Integer [] intArray = {3, 2, 8, 1, 5, 9, 7};   
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        log.info("List of Integers: {}", listOfIntegers);
        Collections.sort(listOfIntegers);
        log.info("Sorted list of integers: {}", listOfIntegers);
    }    
    
    public void demonstrateOrderAnagramsWithLargestAnagramGroupAtFirst() {
        log.info("");
        List<List<String>> winner = Anagram.anagramsList(8);
        Comparator<List<String>> normal = (l1, l2) -> l1.size() - l2.size();
        Comparator<List<String>> reversed = normal.reversed();

        log.info("Ordered from largest to ...");
        Collections.sort(winner, reversed);
        winner
            .forEach(l -> log.info("Size: {}, {}",l.size(), l));
    }

    public void demonstrateShuffle() {
        Integer [] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new ArrayList<>(Arrays.asList(intArray));
        log.info("");
        log.info("List: {}", list);
        Collections.shuffle(list, new Random());
        log.info("Shuffled List: {}", list);

    }

    // looks for the specified search key and inserts it at the appropriate position if it's not already present
    public void demonstrateSearchingAndIfNotFoundandInsertsAtAppropriatePosition() {
        log.info("");
        Integer [] intArray = {1, 3 , 5, 7, 9};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        log.info("List: {}", listOfIntegers);
        Collections.sort(listOfIntegers);
        log.info("Sorted List: {}", listOfIntegers);

        Integer key = Integer.valueOf(6);
        int pos = Collections.binarySearch(listOfIntegers, key);
        log.info("Searching: Key={}, Pos={}", key, pos);
        if(pos < 0) {
            listOfIntegers.add(((-pos) - 1) , key);
            log.info("Add: key={}, pos={} ", key, (((-pos)-1)));
            log.info("List: {} ", listOfIntegers);
        } else {    
            log.info("{} finded at pos={} ", key, pos);
        }

    }

    public static void main(String[] args) {
        CollectionAlgorithmsDemo demo = new CollectionAlgorithmsDemo();

        demo.demonstrateSorting();
        demo.demonstrateOrderAnagramsWithLargestAnagramGroupAtFirst();
        demo.demonstrateShuffle();
        demo.demonstrateSearchingAndIfNotFoundandInsertsAtAppropriatePosition();
    }
}
