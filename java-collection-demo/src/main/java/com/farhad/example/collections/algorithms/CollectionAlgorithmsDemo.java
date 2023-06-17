package com.farhad.example.collections.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

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
        List<Integer> listOfIntegers = getSortedIntegerList();
        log.info("Sorted List: {}", listOfIntegers);

        int key = 6;
        searchAndHandleResult(listOfIntegers, key);

        key = 3; 
        searchAndHandleResult(listOfIntegers, key);

        key = 8; 
        searchAndHandleResult(listOfIntegers, key);
    }

    private List<Integer> getSortedIntegerList() {
        Integer [] intArray = {1, 3 , 5, 7, 9};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        Collections.sort(listOfIntegers);
        return listOfIntegers;
    }

    private void searchAndHandleResult(List<Integer> list, int key) {
        log.info("");
        int pos = search(list, key);
        log.info("Searching: Key={}, Pos={}", key, pos);
        handleSearchResult(list, key, pos);
    }

    private int search(List<Integer> list, int key) {
        Integer integerKey = Integer.valueOf(key);
        int pos = Collections.binarySearch(list, integerKey);
        return pos;
    }

    private void handleSearchResult(List<Integer> list, int key, int pos) {
        if(pos < 0) {
            list.add(((-pos) - 1) , key);
            log.info("Add: key={}, pos={} ", key, (((-pos)-1)));
            log.info("List: {} ", list);
        } else {    
            log.info("{} finded at pos={} ", key, pos);
        }
    } 

    public void demonstrateDisjoint() {
        log.info("");
        
        Integer [] oddIntArray = {1, 3 , 5, 7, 9};
        Integer [] evenIntArray = {0, 2 , 6, 8, 10};
        Integer [] fibonacciNumbers = {0, 1, 1, 2, 3, 5, 8, 13};

        checkDisjoint(oddIntArray, evenIntArray);

        checkDisjoint(oddIntArray, fibonacciNumbers);

        checkDisjoint(fibonacciNumbers, evenIntArray);
    }

    private void checkDisjoint(Integer [] first, Integer [] second) {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(first));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(second));
        log.info("{} and {} are {}", firstList, secondList, Collections.disjoint(firstList, secondList) ? "disjoint!" : "not disjoint!");
    }

    public void demonstratefrequency() {
        log.info("");
        int sizeOfList = 50;
        int randomIntegerHighBound = 10;
        List<Integer> listOfIntegers = randomList(sizeOfList, randomIntegerHighBound);
        printFrequency(listOfIntegers, randomIntegerHighBound);

        sizeOfList = 500;
        randomIntegerHighBound = 10;
        listOfIntegers = randomList(sizeOfList, randomIntegerHighBound);
        printFrequency(listOfIntegers, randomIntegerHighBound);

        sizeOfList = 500;
        randomIntegerHighBound = 1000;
        listOfIntegers = randomList(sizeOfList, randomIntegerHighBound);
        printFrequency(listOfIntegers, randomIntegerHighBound);
    }

    private List<Integer> randomList(int size, int highBound) {
        Faker faker = new Faker();
        List<Integer> ints =  faker.<Integer>collection(
                                        () -> faker.random().nextInt(highBound))
                                    .len(size)
                                    .generate();
        return ints;
    }

    private void printFrequency(List<Integer> list, int highBound) {
        log.info("");
        IntStream.range(0, highBound)
                    .boxed()
                    .forEach(i -> {
                        int f = Collections.frequency(list, i);
                        if(f > 0) {
                            log.info("Number: {}, frequency: {}", i, f);
                        }
                    });
    }

    public static void main(String[] args) {
        CollectionAlgorithmsDemo demo = new CollectionAlgorithmsDemo();

        demo.demonstrateSorting();
        demo.demonstrateOrderAnagramsWithLargestAnagramGroupAtFirst();
        demo.demonstrateShuffle();
        demo.demonstrateSearchingAndIfNotFoundandInsertsAtAppropriatePosition();
        demo.demonstrateDisjoint();
        demo.demonstratefrequency();
    }
}
