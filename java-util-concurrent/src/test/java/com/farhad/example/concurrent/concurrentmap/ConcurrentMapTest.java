package com.farhad.example.concurrent.concurrentmap;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcurrentMapTest {
    
    @Test
    public void concurrentNavigableMapTest() {

        ConcurrentNavigableMap<String,String> map = new ConcurrentSkipListMap<>();

        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");
        map.put("4", "Four");

        ConcurrentNavigableMap<String,String> headMap = map.headMap("2");
        log.info("headMap: {}", headMap);

        ConcurrentNavigableMap<String,String> tailMap = map.tailMap("2");
        log.info("tailMap: {}", tailMap);

        ConcurrentNavigableMap<String,String> subMap = map.subMap("2", "4");
        log.info("subMap: {}", subMap);
    }
}
