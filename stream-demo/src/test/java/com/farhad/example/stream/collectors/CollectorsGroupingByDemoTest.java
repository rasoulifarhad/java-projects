package com.farhad.example.stream.collectors;

import static com.farhad.example.stream.collectors.model.student.Student.STUDENTS;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.stream.collectors.model.student.Student;

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

    @Test
    public void collectWithCollectorsPartitioningByNameLengthGreaterThan4() {
        List<String> names = Arrays.asList("John", "Jane", "Michael", "Anna", "James");
        Map<Boolean, List<String>> partitionByNameLength = 
                    names.stream()
                        .collect(Collectors.partitioningBy(name -> name.length() > 4));
        log.info("{}",partitionByNameLength);
        assertThat(partitionByNameLength)
            .hasSize(2)
            .containsEntry(false, Arrays.asList("John", "Jane", "Anna"))
            .containsEntry(true, Arrays.asList("Michael", "James"));

    }

    @Test
    public void collectWithCollectorsPartitioningByNameLengthAndAvgGrade() {
        Map<Boolean, List<Student>> partitionByNameAndAvgGrade = 
                STUDENTS.stream()
                            .collect(
                                partitioningBy(
                                    student -> student.getName().length() > 8 
                                    && student.getAvgGrade() > 8.0));
        log.info("{}", partitionByNameAndAvgGrade);

        assertThat(partitionByNameAndAvgGrade)
            .hasSize(2);
    }

    @Test
    public void collectWithCollectorsPartitioningByNameLengthAndAvgGradeAndDownstreamMapppingCollector() {
        Map<Boolean, List<String>> partitionByNameAndAvgGrade = 
                STUDENTS.stream()
                            .collect(
                                partitioningBy(
                                    student -> student.getName().length() > 8 
                                    && student.getAvgGrade() > 8.0,
                                    mapping(s -> s.getName() + " " + s.getSurname(), toList())));
        log.info("{}", partitionByNameAndAvgGrade);

        assertThat(partitionByNameAndAvgGrade)
            .hasSize(2);
    }

    @Test
    public void collectWithCollectorsPartitioningByNameLengthAndAvgGradeAndDownstreamCountingCollector() {
        Map<Boolean, Long> partitionByNameAndAvgGrade = 
                STUDENTS.stream()
                    .collect(partitioningBy(
                        s -> s.getName().length() > 8
                        && s.getAvgGrade() > 8.0, 
                        counting())); 
        log.info("{}", partitionByNameAndAvgGrade);

        assertThat(partitionByNameAndAvgGrade)
            .hasSize(2)
            .containsEntry(false, Long.valueOf(4))
            .containsEntry(true, Long.valueOf(1))
            ;
    }

}
