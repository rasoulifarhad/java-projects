package com.farhad.example.stream.collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OtherCollectorsDemoTest {
    @Test
    void testCollectToUnModifiableList() {
        OtherCollectorsDemo demo = new OtherCollectorsDemo();
        Integer [] ints = {1, 2, 3};
        List<Integer> unModifiableNumbers = demo.collectToUnModifiableList(ints);

        assertThat(unModifiableNumbers)
                .hasSize(3)
                .containsOnly(1, 2, 3);
        assertThatThrownBy(unModifiableNumbers::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void testCollectorsJoining() {
        OtherCollectorsDemo demo = new OtherCollectorsDemo();
        Integer [] ints = {1, 2, 3};
        String joinedNumbers = demo.collectorsJoining(ints);

        assertThat(joinedNumbers).isEqualTo("123");
    }

    @Test
    void testCollectorsJoiningWithDelimiter() {
        OtherCollectorsDemo demo = new OtherCollectorsDemo();
        Integer [] ints = {1, 2, 3};
        String joinedNumbers = demo.collectorsJoining(ints, ",");

        assertThat(joinedNumbers).isEqualTo("1,2,3");
    }
    
    @Test
    void testCollectorsJoiningWithDelimiterPrefixSuffix() {
        OtherCollectorsDemo demo = new OtherCollectorsDemo();
        Integer [] ints = {1, 2, 3};
        String joinedNumbers = demo.collectorsJoining(ints, ",", "[", "]");

        assertThat(joinedNumbers).isEqualTo("[1,2,3]");
    }

    @Test
    void testCollectiorsTeeing() {
        OtherCollectorsDemo demo = new OtherCollectorsDemo();
        Integer [] ints = {1, 2, 3};
        Entry<Optional<Integer>, Optional<Integer>> limits = demo.collectiorsTeeing(ints);
        
        assertNotNull(limits);

        Optional<Integer> minOptional = limits.getKey();
        assertThat(minOptional)
              .isNotEmpty()
              .hasValue(1);

        Optional<Integer> maxOptional = limits.getValue();
        assertThat(maxOptional)
              .isNotEmpty()
              .hasValue(3);
    }
}
