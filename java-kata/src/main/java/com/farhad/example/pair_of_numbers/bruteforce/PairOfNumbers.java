package com.farhad.example.pair_of_numbers.bruteforce;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Value;

public class PairOfNumbers {
    

    @Value
    @AllArgsConstructor
    public static class Pair {
        private int a;
        private int b;
    }

    public static Optional<Pair> pairOfNumber(int[] numbers, int sum) {

        for (int i = 0; i < numbers.length; i++) {
            int diff = sum - numbers[i] ;
            if(diff <= 0) {
                continue;
            }
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[j] == diff) {
                    return Optional.of(new Pair(numbers[i], numbers[j]));
                }
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        
        int [] numbers = {8, 10, 2, 9, 7, 5};
        System.out.println(pairOfNumber(numbers, 11));
    }
}
