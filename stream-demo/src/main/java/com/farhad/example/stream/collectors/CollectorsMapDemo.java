package com.farhad.example.stream.collectors;

import static java.util.stream.Collectors.toConcurrentMap;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toUnmodifiableMap;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectorsMapDemo {
    
    public Map<Character, String> demonstrateCollectorsToMapNoKeysCollisions(String [] a) {
        log.info("");
        Map<Character, String> map = Stream.of(a)
                                        .collect(
                                            toMap( 
                                                s -> s.charAt(0), 
                                                Function.identity()));
        log.info("List: {}, map: {}", Arrays.asList(a), map);
        return map;
    }

    public Map<Character, String>  demonstrateCollectorsToMapKeysCollisions(String [] a) {
        log.info("");
        Map<Character, String> map =  Stream.of(a)
                                        .collect(toMap( s -> s.charAt(0), Function.identity()));
        log.info("List: {}, map: {}", Arrays.asList(a), map);
        return map;
    }

    public Map<Character, String> demonstrateCollectorsToMapWithKeyMapperAndValueMapperAndMergeFunction(String [] a) {
        log.info("");
        Map<Character, String> map = Stream.of(a)
                                        .collect(
                                            toMap( 
                                                s -> s.charAt(0), 
                                                Function.identity(), 
                                                (v1, v2) -> v2));
        log.info("List: {}, map: {}", Arrays.asList(a), map);
        return map;
    } 

    public Map<Character, String> demonstrateCollectorsToMapWithKeyMapperAndValueMapperAndMergeFunctionAndMapFactory(String [] a) {
        log.info("");
        Map<Character, String> map = Stream.of(a)
                                        .collect(
                                            toMap( 
                                                s -> s.charAt(0), 
                                                Function.identity(), 
                                                (v1, v2) -> v2, 
                                                TreeMap::new));
        log.info("List: {}, map: {}", Arrays.asList(a), map);
        return map;
    } 

    public Map<Character, String> demonstrateCollectorsToUnmodifiableMapNoKeysCollisions(String [] a) {
        log.info("");
        Map<Character, String> unmodifiableMap = Stream.of(a)
                                                    .collect(
                                                        toUnmodifiableMap( 
                                                            s -> s.charAt(0), 
                                                            Function.identity()));
        log.info("List: {}, unmodifiableMap: {}", Arrays.asList(a), unmodifiableMap);
        return unmodifiableMap;
    }

    public Map<Character, String>  demonstrateCollectorsToUnmodifiableMapKeysCollisions(String [] a) {
        log.info("");
        Map<Character, String> unmodifiableMap =  Stream.of(a)
                                        .collect(toUnmodifiableMap( s -> s.charAt(0), Function.identity()));
        log.info("List: {}, map: {}", Arrays.asList(a), unmodifiableMap);
        return unmodifiableMap;
    }

    public Map<Character, String> demonstrateCollectorsToUnmodifiableWithKeyMapperAndValueMapperAndMergeFunction(String [] a) {
        log.info("");
        Map<Character, String> unmodifiableMap = Stream.of(a)
                                        .collect(
                                            toUnmodifiableMap( 
                                                s -> s.charAt(0), 
                                                Function.identity(), 
                                                (v1, v2) -> v2));
        log.info("List: {}, map: {}", Arrays.asList(a), unmodifiableMap);
        return unmodifiableMap;
    } 

    public ConcurrentMap<Character, String> demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapper(String [] a) {
        log.info("");
        ConcurrentMap<Character, String> concurrentMap = 
                        Stream.of(a)
                           .parallel()
                           .collect(
                                Collectors.toConcurrentMap(
                                        s -> s.charAt(0), 
                                        Function.identity()));
        log.info("List: {}, concurrentMap: {}", Arrays.asList(a), concurrentMap);
        return concurrentMap;
    }

    public ConcurrentMap<Character, String> demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapperAndMergeFunction(String [] a) {
        log.info("");
        ConcurrentMap<Character, String> concurrentMap = 
                        Stream.of(a)
                            .parallel()
                            .collect(
                                toConcurrentMap(
                                    s -> s.charAt(0), 
                                    Function.identity(), 
                                    (v1, v2) -> v2));
        log.info("List: {}, concurrentMap: {}", Arrays.asList(a), concurrentMap);
        return concurrentMap;
    }
    

    public ConcurrentMap<Character, String> demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapperAndMergeFunctionAndMapFactory(String [] a) {
        log.info("");
        ConcurrentMap<Character, String> concurrentMap = 
                    Stream.of(a)
                        .parallel()
                        .collect(
                            toConcurrentMap(
                                s -> s.charAt(0),
                                Function.identity(), 
                                (v1, v2) -> v2, 
                                ConcurrentHashMap::new));
        log.info("List: {}, concurrentMap: {]}", Arrays.asList(a), concurrentMap);
        return concurrentMap;
    }                       

    public static void main(String[] args) {
        CollectorsMapDemo demo = new CollectorsMapDemo();

        String [] a = {"Alpha", "Bravo", "Charlie"};
        demo.demonstrateCollectorsToMapNoKeysCollisions(a);
        
        try {
            a = new String[]{"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
            demo.demonstrateCollectorsToMapNoKeysCollisions(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // a = new String[]{"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
        demo.demonstrateCollectorsToMapWithKeyMapperAndValueMapperAndMergeFunction(a);

        demo.demonstrateCollectorsToMapWithKeyMapperAndValueMapperAndMergeFunctionAndMapFactory(a);

        a = new String[] {"Alpha", "Bravo", "Charlie"};
        demo.demonstrateCollectorsToUnmodifiableMapNoKeysCollisions(a);

        try {
            a = new String[]{"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
            demo.demonstrateCollectorsToUnmodifiableMapKeysCollisions(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

        a = new String[]{"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
        demo.demonstrateCollectorsToUnmodifiableWithKeyMapperAndValueMapperAndMergeFunction(a);

        a = new String[] {"Alpha", "Bravo", "Charlie"};
        demo.demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapper(a);

        try {
            a = new String[]{"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
            demo.demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapper(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

        a = new String[]{"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
        demo.demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapperAndMergeFunction(a);

        a = new String[]{"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
        demo.demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapperAndMergeFunctionAndMapFactory(a);
    }


}
