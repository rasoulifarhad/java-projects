package com.farhad.example.collections.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

    public static <E> void swap(List<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static <E> void shuffle(List<E> list, Random rnd) {
        for (int i = list.size(); i > 1; i--) {
            swap(list, i-1, rnd.nextInt(i));
        }
    }

    public static void main(String[] args) {

        Integer [] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new ArrayList<>(Arrays.asList(intArray));
        log.info("");
        log.info("List: {}", list);
        shuffle(list, new Random());
        log.info("Shuffled List: {}", list);
    }
}
