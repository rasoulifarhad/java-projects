package com.farhad.example.stream.collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollectorsMapDemoTest {

    private CollectorsMapDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new CollectorsMapDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateCollectorsToMapNoKeysCollisions() {
        String [] a = {"Alpha", "Bravo", "Charlie"};
        Map<Character, String> map = demo.demonstrateCollectorsToMapNoKeysCollisions(a);

        assertThat(map)
            .hasSize(3)
            .containsEntry('A', "Alpha")
            .containsEntry('B', "Bravo")
            .containsEntry('C', "Charlie");
    }

    @Test
    void testDemonstrateCollectorsToMapKeysCollisions() {
        assertThrows(IllegalStateException.class, 
                        () -> {
                            String [] a = {"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
                            demo.demonstrateCollectorsToMapKeysCollisions(a);
                        });
    }

    @Test
    void testDemonstrateCollectorsToMapWithKeyMapperAndValueMapperAndMergeFunction() {
        String [] a = {"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
        Map<Character, String> map = demo.demonstrateCollectorsToMapWithKeyMapperAndValueMapperAndMergeFunction(a);

        assertThat(map)
            .hasSize(3)
            .containsEntry('A', "Alpha")
            .containsEntry('B', "Bravo")
            .containsEntry('C', "Charlie");
    }

    @Test
    void testDemonstrateCollectorsToMapWithKeyMapperAndValueMapperAndMergeFunctionAndMapFactory() {
        String [] a = {"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
        Map<Character, String> map = demo.demonstrateCollectorsToMapWithKeyMapperAndValueMapperAndMergeFunctionAndMapFactory(a);

        assertThat(map)
            .hasSize(3)
            .containsEntry('A', "Alpha")
            .containsEntry('B', "Bravo")
            .containsEntry('C', "Charlie")
            .isExactlyInstanceOf(TreeMap.class);
    }

    @Test
    void testDemonstrateCollectorsToUnmodifiableMapNoKeysCollisions() {
        String [] a = {"Alpha", "Bravo", "Charlie"};
        Map<Character, String> unmodifiableMap = demo.demonstrateCollectorsToUnmodifiableMapNoKeysCollisions(a);

        assertThat(unmodifiableMap)
            .hasSize(3)
            .containsEntry('A', "Alpha")
            .containsEntry('B', "Bravo")
            .containsEntry('C', "Charlie");

        assertThatThrownBy(unmodifiableMap::clear)
                        .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void testDemonstrateCollectorsToUnmodifiableMapKeysCollisions() {
        assertThrows(IllegalStateException.class, 
                () -> {
                    String [] a = {"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
                    demo.demonstrateCollectorsToUnmodifiableMapKeysCollisions(a);
                });
    }

    @Test
    void testDemonstrateCollectorsToUnmodifiableWithKeyMapperAndValueMapperAndMergeFunction() {
        String [] a = {"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
        Map<Character, String>  unmodifiableMap = demo.demonstrateCollectorsToUnmodifiableWithKeyMapperAndValueMapperAndMergeFunction(a);

        assertThat(unmodifiableMap)
            .hasSize(3)
            .containsEntry('A', "Alpha")
            .containsEntry('B', "Bravo")
            .containsEntry('C', "Charlie");
        
        assertThatThrownBy(unmodifiableMap::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void testDemonstrateCollectorsToConcurrentMapNoKeysCollisionsWithKeyMapperAndValueMapper() {
        String [] a = {"Alpha", "Bravo", "Charlie"};
        ConcurrentMap<Character, String> concurrentMap = demo.demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapper(a);

        assertThat(concurrentMap)
            .hasSize(3)
            .containsEntry('A', "Alpha")
            .containsEntry('B', "Bravo")
            .containsEntry('C', "Charlie");
    }

    @Test
    void testDemonstrateCollectorsToConcurrentMapKeysCollisionsWithKeyMapperAndValueMapper() {

        assertThrows(IllegalStateException.class, 
                    () -> {
                        String [] a = {"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
                        demo.demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapper(a);
                    });
    }

    @Test
    public void testDemonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapperAndMergeFunction() {
        String [] a = {"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
        ConcurrentMap<Character, String> concurrentMap = demo.demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapperAndMergeFunction(a);

        assertThat(concurrentMap)
            .hasSize(3)
            .containsKey('A')
            .containsKey('B')
            .containsKey('C');
    }

    @Test
    public void testDemonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapperAndMergeFunctionAndMapFactory() {
        String [] a = {"Amsterdam", "Baltimore", "Casablanca", "Alpha", "Bravo", "Charlie"};
        ConcurrentMap<Character, String> concurrentMap = demo.demonstrateCollectorsToConcurrentMapMayBeKeysCollisionsWithKeyMapperAndValueMapperAndMergeFunctionAndMapFactory(a);

        assertThat(concurrentMap)
            .hasSize(3)
            .containsKey('A')
            .containsKey('B')
            .containsKey('C')
            .isExactlyInstanceOf(ConcurrentHashMap.class); 

    }
}
