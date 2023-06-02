package com.farhad.example.string;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollatorBasedCloseEnoughComparatorTest {
    
    @Test
    public void anotherCloseEnoughComparatorTest() {
        String str1 = "bleu fonce";
        String str2 = "Bleu foncé   ";

        Comparator<String> comparator = new CollatorBasedCloseEnoughComparator();
        if (comparator.compare(str1, str2) == 0) {
            log.info("str1 and str2 have equal values.");
        } else {
            log.info("str1 and str2 do Not have equal values.");
        }
    }

}
