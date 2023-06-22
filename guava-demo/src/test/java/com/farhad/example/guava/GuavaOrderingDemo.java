package com.farhad.example.guava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import com.google.common.base.Functions;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaOrderingDemo {
    
    @Test 
    public void demonstrateOrderNullValuesFirst() {
        List<Integer> numbers = Arrays.asList(3, 5, 4, null, 1, 2 );
        Collections.sort(numbers, Ordering.natural().nullsFirst());
        assertThat(numbers.get(0)).isNull();
    }

    @Test
    public void demonstrateOrderNullValuesLast() {
        List<Integer> numbers = Arrays.asList(3, 5, 4, null, 1, 2);
        Collections.sort(numbers, Ordering.natural().nullsLast());
        assertThat(numbers.get(numbers.size() - 1)).isNull();
    }

    @Test
    public void demonstrateOrderNullValuesLastReverse() {
        List<Integer> numbers = Arrays.asList(3, 5, 4 , null, 1 , 2);
        Collections.sort(numbers, Ordering.natural().nullsLast().reverse());
        assertThat(numbers.get(0)).isNull();
    }

    @Test
    public void demonstrateNaturalOrdering() {
        List<Integer> numbers = Arrays.asList(3, 5, 4, 1, 2);
        Collections.sort(numbers, Ordering.natural());
        assertTrue(Ordering.natural().isOrdered(numbers));
    }

    @Test
    public void demonstrateReverseOrdering() {
        List<Integer> numbers = Arrays.asList(3, 5, 4, 1, 2);
        Collections.sort(numbers, Ordering.natural().reversed());
        assertThat(numbers).contains(5, 4, 3, 2, 1);
    }

    @Test
    public void demonstrateOrderingStringsByLength() {
        List<String> listOfStrings = Arrays.asList("zz", "aa", "b", "ccc");
        Collections.sort(listOfStrings, new OrderingByLength());
        log.info("{}", listOfStrings);
        Ordering<String> expectedOrdering = Ordering.explicit( Lists.newArrayList("b", "zz", "aa", "ccc"));
        assertTrue(expectedOrdering.isOrdered(listOfStrings));
    }

    class OrderingByLength extends Ordering<String> {

        @Override
        public int compare(String left, String right) {
            return Ints.compare(left.length(), right.length());
        }
    }

    @Test
    public void demonstrateCheckingStringOrdering() {
        List<Integer> numbers = Arrays.asList(3, 5, 4, 1, 2);
        Collections.sort(numbers, Ordering.natural());
        log.info("{}", numbers);
        assertFalse(Ordering.natural().isStrictlyOrdered(numbers));
    }

    @Test
    public void demonstrateSecondaryOrdering() {
        List<String> listOfString = Arrays.asList("zz", "aa", "b", "ccc");
        Ordering<String> byLength = new OrderingByLength();
        Collections.sort(listOfString, byLength.compound(Ordering.natural()));
        log.info("{}", listOfString);
        Ordering<String> expectedOrder = Ordering.explicit(Lists.newArrayList("b", "aa", "zz", "ccc"));
        assertTrue(expectedOrder.isOrdered(listOfString));
    }

    @Test
    public void demonstrateChainingOrdering() {
        List<String> listOfStrings = Arrays.asList("zz", "aa", null, "b", "ccc");
        Collections.sort(listOfStrings, 
                    new OrderingByLength()
                        .reverse()
                        .compound(
                            Ordering.natural())
                        .nullsLast());
        log.info("{}", listOfStrings);
    }

    @Test 
    public void demonstrateSortUsingToStringRepresentation() {
        List<Integer> numbers = Arrays.asList(1, 5, 11, 2, 22);
        Collections.sort(numbers, Ordering.usingToString());
        log.info("{}", numbers);
        Ordering<Integer> expectedOrder = Ordering.explicit(Lists.newArrayList(1, 11, 2, 22, 5));
        assertTrue(expectedOrder.isOrdered(numbers));
    }

    @Test
    public void demonstrateSortThenFind() {
        List<Integer> numbers = Arrays.asList(1, 5, 11, 2, 22);
        Collections.sort(numbers, Ordering.usingToString());
        int found = Ordering.usingToString().binarySearch(numbers, 2);
        found = Collections.binarySearch(numbers, 2);
        log.info("{}", found);
    }

    @Test
    public void demonstrateFindMinMaxWithoutHavingToSort() {
        List<Integer> numbers = Arrays.asList(1, 11, 2, 22, 5);
        int min = Ordering.usingToString().min(numbers);
        int max = Ordering.usingToString().max(numbers);
        assertThat(min).isEqualTo(1);
        assertThat(max).isEqualTo(5);
        log.info("min: {}, max: {}", min, max);
    }
    @Test
    public void demonstrateCreateSortedCopyOfListFromAnOrdering() {
        List<String> listOfStrings = Arrays.asList("zz", "aa", "b", "ccc");
        List<String> sortedCopy = new OrderingByLength().sortedCopy(listOfStrings);
        log.info("{}", sortedCopy);
        Ordering<String> expectedOrder = Ordering.explicit(Lists.newArrayList("b", "zz", "aa", "ccc"));
        assertTrue(expectedOrder.isOrdered(sortedCopy));
        assertFalse(expectedOrder.isOrdered(listOfStrings));
    }

    @Test
    public void demonstrateCreateSortedPartialCopy() {
        List<Integer> listOfInteger = Arrays.asList(2, 1, 12, 44, 8, 22);
        List<Integer> leastOf = Ordering.natural().leastOf(listOfInteger, 3);
        List<Integer> expected = Lists.newArrayList(1, 2, 8);
        assertThat(leastOf).containsExactlyElementsOf(expected);
    }
    @Test
    public void demonstrateOrderingViaIntermediaryFunction() {
        List<Integer> listOfInteger = Arrays.asList(2, 1, 12, 44, 8, 22);
        Ordering<Object> ordering = Ordering.natural().onResultOf(Functions.toStringFunction());
        List<Integer> sortedCopy = ordering.sortedCopy(listOfInteger);
        log.info("{}", sortedCopy);
        List<Integer> expected = Lists.newArrayList(1, 12, 2, 22, 44, 8);
        assertThat(sortedCopy).containsExactlyElementsOf(expected);
    }
}
