package com.farhad.example.stream.collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollectorsDemoTest {

    private static final Integer [] UNIQUE_INTS = {1, 2, 3, 4, 5};
    private static final Integer    UNIQUE_INTS_MAX = Integer.valueOf(5);
    private static final Integer    UNIQUE_INTS_MIN = Integer.valueOf(1);
    private static final Integer    UNIQUE_INTS_SUM = Integer.valueOf(15);
    private static final Integer    UNIQUE_INTS_SUM_OF_SQUARES = Integer.valueOf(55);
    private static final Double     UNIQUE_INTS_AVERAGE = Double.valueOf(3.0);
    private static final Integer [] NONE_UNIQUE_INTS = {1, 1, 2, 2, 3, 3, 4, 5, 5};
    private static final Integer [] ODD_NUMBERS = {1, 3, 5};
    private static final Integer [] EVEN_NUMBERS = {0, 2, 4};
    private static final Integer [] ODD_EVEN_NUMBERS = {0, 1, 2, 3, 4, 5};

    private static final Integer [] UNIQUE_INTS_IN_POWER_OF_2 = {1, 4, 9, 16, 25};

    private CollectorsDemo demo ;

    @BeforeEach
    public void setUp() {
        demo = new CollectorsDemo();
    }

    @AfterEach
    public void tearDown() {
        demo = null;
    }

    @Test
    void testDemonstrateToList() {
        List<Integer> list = demo.demonstrateToList(UNIQUE_INTS);
        assertThat(list)
            .hasSize(UNIQUE_INTS.length)
            .contains(UNIQUE_INTS);
    }

    @Test
    void testDemonstrateToSet() {
        Set<Integer> set = demo.demonstrateToSet(NONE_UNIQUE_INTS);
        assertThat(set)
            .hasSize(UNIQUE_INTS.length)
            .contains(UNIQUE_INTS);
    }

    @Test
    void testDemonstrateToSpecificCollectionArrayLIst() {
        List<Integer> list = demo.demonstrateToSpecificCollectionArrayLIst(UNIQUE_INTS);
        assertThat(list)
            .hasSize(UNIQUE_INTS.length)
            .contains(UNIQUE_INTS)
            .isExactlyInstanceOf(ArrayList.class);
    }

    @Test
    void testDemonstrateToUnmodifiableList() {
        List<Integer> list = demo.demonstrateToUnmodifiableList(UNIQUE_INTS);
        assertThat(list)
            .hasSize(UNIQUE_INTS.length)
            .containsOnly(UNIQUE_INTS);
        assertThatThrownBy(list::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void testDemonstrateToUnmodifiableSet() {
        Set<Integer> unmodifiableSet = demo.demonstrateToUnmodifiableSet(NONE_UNIQUE_INTS);
        assertThat(unmodifiableSet)
            .hasSize(UNIQUE_INTS.length)
            .containsOnly(UNIQUE_INTS);

        assertThatThrownBy(unmodifiableSet::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void testDemonsterateCollectorsMapping() {
        List<Integer>  ints = demo.demonsterateCollectorsMapping(UNIQUE_INTS);
        assertThat(ints)
            .hasSize(UNIQUE_INTS_IN_POWER_OF_2.length)
            .containsOnly(UNIQUE_INTS_IN_POWER_OF_2);       
    }

    @Test
    void testDemonstrateCollectorsFiltering() {
        List<Integer> oddNumbers = demo.demonstrateCollectorsFiltering(UNIQUE_INTS);
        assertThat(oddNumbers)
            .hasSize(ODD_NUMBERS.length)
            .containsOnly(ODD_NUMBERS);
    }

    @Test
    void testDemonstrateCollectorsFlatMapping() {
        List<Integer> ints = demo.demonstrateCollectorsFlatMapping(ODD_NUMBERS, EVEN_NUMBERS);
        assertThat(ints)
            .hasSize(ODD_EVEN_NUMBERS.length)
            .containsOnly(ODD_EVEN_NUMBERS);
    }

    @Test
    void testDemonstrateCollectorsAveraging() {
        double average = demo.demonstrateCollectorsAveraging(UNIQUE_INTS);
        assertThat(average).isEqualTo(UNIQUE_INTS_AVERAGE.doubleValue());
    }

    @Test
    void testDemonstrateCollectorsCounting() {
        long count = demo.demonstrateCollectorsCounting(UNIQUE_INTS);
        assertThat(count).isEqualTo(UNIQUE_INTS.length);
        assertEquals(UNIQUE_INTS.length, count);
    }

    @Test
    void testDemonstrateCollectorsMaxBy() {
        Optional<Integer> max = demo.demonstrateCollectorsMaxBy(UNIQUE_INTS);
        assertThat(max)
                .isNotEmpty()
                .hasValue(UNIQUE_INTS_MAX.intValue());
    }

    @Test
    void testDemonstrateCollectorsMinBy() {
        Optional<Integer> min = demo.demonstrateCollectorsMinBy(UNIQUE_INTS);
        assertThat(min)
            .isNotEmpty()
            .hasValue(UNIQUE_INTS_MIN.intValue());
    }

    @Test
    void testDemonstrateCollectorsSummingInt() {
       int sum = demo.demonstrateCollectorsSummingInt(UNIQUE_INTS); 

       assertThat(sum)
            .isEqualTo(UNIQUE_INTS_SUM.intValue());
    }

    @Test
    void testDemonstrateCollectorsSummarizingInt() {
        IntSummaryStatistics iss = demo.demonstrateCollectorsSummarizingInt(UNIQUE_INTS);
        assertThat(iss.getAverage()).isEqualTo(UNIQUE_INTS_AVERAGE.doubleValue());
        assertThat(iss.getCount()).isEqualTo(UNIQUE_INTS.length);
        assertThat(iss.getSum()).isEqualTo(UNIQUE_INTS_SUM.longValue());
        assertThat(iss.getMax()).isEqualTo(UNIQUE_INTS_MAX.intValue());
        assertThat(iss.getMin()).isEqualTo(UNIQUE_INTS_MIN.intValue());

    }

    @Test
    void testDemonstrateCollectorsReducingWithOperatorParmeters() {
        Optional<Integer> sum = demo.demonstrateCollectorsReducingWithOperatorParmeters(UNIQUE_INTS);
        assertTrue(sum.isPresent());
        assertThat(sum.get()).isEqualTo(UNIQUE_INTS_SUM);
    }

    @Test
    void testDemonstrateCollectorsReducingWithIdentityAndOperatorParmeters() {
        Integer sum = demo.demonstrateCollectorsReducingWithIdentityAndOperatorParmeters(UNIQUE_INTS);
        assertThat(sum).isEqualTo(UNIQUE_INTS_SUM);
    }

    @Test
    void testDemonstrateCollectorsReducingWithIdentityMapperAndAndOperatorParmetersToCalculateSumOfSquares() {
        Integer sumOfSquares = demo.demonstrateCollectorsReducingWithIdentityMapperAndAndOperatorParmetersToCalculateSumOfSquares(UNIQUE_INTS);
        assertThat(sumOfSquares).isEqualTo(UNIQUE_INTS_SUM_OF_SQUARES);
    }

}
