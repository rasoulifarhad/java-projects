package com.farhad.example.stream.collectors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectorsGroupingByDemoTest {

    private CollectorsGroupingByDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new CollectorsGroupingByDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }
    
    @Test
    void testPartitioinNumbersByReminderFromDivisionBy2() {
        log.info("");
        Integer [] numbers = {1, 2, 3};
        Map<Boolean, List<Integer>> partitionedNumbers = demo.partitioinNumbersByReminderFromDivisionBy2(numbers);

        assertThat(partitionedNumbers)
            .hasSize(2)
            .containsEntry(false, List.of(1, 3))
            .containsEntry(true, List.of(2));

    }

    @Test
    void testPartitioinNumbersByIfReminderFromDivisionBy4IsZero() {
        log.info("");
        Integer [] numbers = {1, 2, 3};
        Map<Boolean, Set<Integer>> map = demo.partitioinNumbersByIfReminderFromDivisionBy4IsZero(numbers);

        assertThat(map)
            .hasSize(2)
            .containsEntry(true, Set.of())
            .containsEntry(false, Set.of(1, 2, 3));
    }
}
