package com.farhad.example.pair_of_numbers.memoized;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int diff = sum - num;
            if(diff <= 0) {
                continue;
            }
            if (seen.contains(diff)) {
                return Optional.of(new Pair(num, diff));
            }
            seen.add(num);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        int [] numbers = {8, 10, 2, 9, 7, 5};
        System.out.println(pairOfNumber(numbers, 11));
    }
}
