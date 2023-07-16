package com.farhad.example.algorithm;

import static com.farhad.example.algorithm.Algorithms.allSubsets;
import static com.farhad.example.algorithm.Algorithms.factorialIterative;
import static com.farhad.example.algorithm.Algorithms.factorialRecursive;
import static com.farhad.example.algorithm.Algorithms.factorialStreams;
import static com.farhad.example.algorithm.Algorithms.factorialTailRecursive;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlgorithmsTest {
    
    @Test
    public void palindromeTest() {

        String s1 = "aba";
        log.info("{} is palindrome? {}", s1, Algorithms.isPalindrome(s1)); 

        s1 = "race a car";
        log.info("{} is palindrome? {}", s1, Algorithms.isPalindrome(s1)); 

        s1 = "A man, a plan, a canal: Panama";
        log.info("{} is palindrome? {}", s1, Algorithms.isPalindrome(s1)); 
    }

    @Test
    public void twoSumTest() {

        int[] numbers = new int[] {2,7,11,15};
        int target = 9;
        log.info("sum of indices of {} is {}", Algorithms.twoSum(numbers, target), target);

        numbers = new int[] {2,3,4};
        target = 6;
        log.info("sum of indices of {} is {}", Algorithms.twoSum(numbers, target), target);

        numbers = new int[] {-1, 0};
        target = -1;
        log.info("sum of indices of {} is {}", Algorithms.twoSum(numbers, target), target);
    }

    @Test
    public void threeSumTest() {
        int [] numbers = new int[] {-1,0,1,2,-1,-4};
        log.info("{}", Algorithms.threeSum(numbers));

        numbers = new int[] {-0,1,1};
        log.info("{}", Algorithms.threeSum(numbers));

        numbers = new int[] {0,0,0};
        log.info("{}", Algorithms.threeSum(numbers));
    }

    @Test
    void testAllSubsets() {
        List<Integer> list = Arrays.asList(1, 4, 9);
        System.out.println(allSubsets(list));
    }

    @Test
    void testFactorialIterative() {
        System.out.println(factorialIterative(10));
    }

    @Test
    void testFactorialRecursive() {
        System.out.println(factorialRecursive(10));    
    }

    @Test
    void testFactorialStreams() {
        System.out.println(factorialStreams(10));
    }

    @Test
    void testFactorialTailRecursive() {
        System.out.println(factorialTailRecursive(10));
    }

}
