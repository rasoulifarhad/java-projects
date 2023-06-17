package com.farhad.example.collections.algorithms;

import static com.farhad.example.collections.algorithms.Utils.shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilsTest {
    @Test
    void testShuffle() {
                Integer [] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = new ArrayList<>(Arrays.asList(intArray));
        log.info("");
        log.info("List: {}", list);
        shuffle(list, new Random());
        log.info("Shuffled List: {}", list);

    }
}
