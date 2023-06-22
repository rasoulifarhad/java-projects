package com.farhad.example.guava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaCoreDemoTest {

    @Test
    void testDemonstrateFilterCollectionByCustomPredicate() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5);
        Predicate<Integer> acceptEven = new Predicate<Integer>() {

            @Override
            public boolean apply(Integer number) {
                return (number % 2) == 0;
            }
        };
        List<Integer> evenNumbers = Lists.newArrayList( Collections2.filter(numbers, acceptEven));
        int found = Collections.binarySearch(evenNumbers, 3);
        assertThat(found).isLessThan(0);
    }

    @Test
    public void demonstrateFilterOutNullsFromCollection() {
        List<String> withNuls = Lists.newArrayList("One", "Two", null, "1", null, "2");
        Iterable<String> withoutNuls = Iterables.filter(withNuls, Predicates.notNull());
        assertTrue( Iterables.all(withoutNuls, Predicates.notNull()));
    }

    @Test
    public void demonstrateCheckConditionForAllElements() {
        List<Integer> evenNumbers = Lists.newArrayList(2, 6, 10 , 24, 38);
        Predicate<Integer> acceptEven = new Predicate<Integer>() {

            @Override
            public boolean apply(Integer number) {
                return (number % 2) == 0;
            }
        };
        assertTrue(Iterables.all(evenNumbers, acceptEven));
    }

    @Test
    public void demonstrateNgatePredicate() {
        List<Integer> evenNumbers = Lists.newArrayList(2, 4, 10, 16, 40);
        Predicate<Integer> acceptOdd = new Predicate<Integer>() {

            @Override
            public boolean apply(Integer number) {
                return (number % 2) != 0 ;
            }
        };
        assertTrue(Iterables.all(evenNumbers, Predicates.not(acceptOdd)));
    }

    @Test 
    public void demonstrateSimpleTransformInCollections() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3);
        List<String> asStrings = Lists.transform(numbers, Functions.toStringFunction());
        assertThat(asStrings).contains("1", "2", "3");
    }

    @Test
    public void demonstrateSortCollectionByFirstApplyIntermediaryFunction() {
        List<Integer> numbers = Lists.newArrayList(1, 11, 8, 25, 100, 40);
        Ordering<Object> ordering = Ordering.natural().onResultOf(Functions.toStringFunction());
        List<Integer> sortedNumbers = ordering.sortedCopy(numbers);
        List<Integer> expectedSortedNumbers = Lists.newArrayList(1, 100, 11, 25, 40, 8);
        log.info("{}",sortedNumbers);
        assertThat(sortedNumbers).isEqualTo(expectedSortedNumbers);
    }

    @Test
    public void demonstrateChainingPredicatesAndFunctions() {
        List<Integer> numbers = Lists.newArrayList(2, 1, 50, 8);
        Predicate<Integer> acceptEvenNumbers = new Predicate<Integer>() {

            @Override
            public boolean apply(Integer number) {
                return (number % 2) == 0;
            }
        };

        Function<Integer, Integer> powerOfTwo = new Function<Integer,Integer>() {

            @Override
            public Integer apply(Integer input) {
                return (int) Math.pow(input, 2);
            }   
        };

        FluentIterable<Integer> powerOfTwoOnlyForEvenNumbers = 
                FluentIterable
                    .from(numbers)
                    .filter(acceptEvenNumbers)
                    .transform(powerOfTwo);
        log.info("{}", powerOfTwoOnlyForEvenNumbers);
        assertThat(powerOfTwoOnlyForEvenNumbers).contains(4, 2500, 64);
    }

    @Test
    public void demonstrateComposeTwoFunctions() {
        List<Integer> numbers = Arrays.asList(2, 3);
        Function<Integer, Integer> powerOfTwo = new Function<Integer,Integer>() {

            @Override
            public Integer apply(Integer input) {
                return (int) Math.pow(input, 2);
            }
        };
        List<Integer> powwerOfFourForNumbers = Lists.transform(numbers, Functions.compose(powerOfTwo, powerOfTwo));
        assertThat(powwerOfFourForNumbers).contains(16, 81);
    }

    @Test
    public void demonstrateCreateMapBackedBySetAndFunction() {

        Function<Integer, Integer> powerOfTwo = new Function<Integer,Integer>() {

            @Override
            public Integer apply(Integer input) {
                return (int) Math.pow(input, 2);
            }
        }; 
        Set<Integer> numbers = Sets.newHashSet(2, 3, 4);
        Map<Integer, Integer> numberToPowerOfTwoMuttable = Maps.asMap(numbers, powerOfTwo);
        Map<Integer, Integer> numberToPowerOfTwoImuttable = Maps.toMap(numbers, powerOfTwo);
        assertThat(numberToPowerOfTwoImuttable.get(2)).isEqualTo(4);
        assertThat(numberToPowerOfTwoMuttable.get(2)).isEqualTo(4);
    }

    @Test
    public void demonstrateCreateFunctionOutOfPredicate() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 6);
        Predicate<Integer> acceptEvenNumber = new Predicate<Integer>() {

            @Override
            public boolean apply(Integer input) {
                return (input % 2) == 0;
            }
        };

        Function<Integer, Boolean> isEvenNumberFunction = Functions.forPredicate(acceptEvenNumber);
        List<Boolean> areNumbersEven = Lists.transform(numbers, isEvenNumberFunction);
        assertThat(areNumbersEven).contains(false, true, false, true);
    }

    @Test
    public void demonstrateReadyMadePredicates() {

        Predicate<Integer> isZero = Predicates.equalTo(0);
        assertThat(isZero.test(0)).isTrue();
        assertFalse(isZero.test(10));

        Predicate<String> isNotNull = Predicates.notNull();
        assertThat(isNotNull.test("Is Not Null")).isTrue();
        assertFalse(isNotNull.test(null));

        Predicate<Object> isString = Predicates.instanceOf(String.class);
        assertThat(isString.test(Integer.valueOf(10))).isFalse();

        Predicate<Object> isNotString = Predicates.not(isString);
        assertThat(isNotString.test(Integer.valueOf(10))).isTrue();

        Predicate<Object> alwaysTrue = Predicates.alwaysTrue();
        assertTrue(alwaysTrue.test("alwaysTrue"));
        assertTrue(alwaysTrue.test((Object)null));

        Predicate<Object> alwaysFalse = Predicates.alwaysFalse();
        assertFalse(alwaysFalse.test("alwaysFalse"));
        assertFalse(alwaysFalse.test((Object)null));
    }

    @Test
    public void demonstrateCombineSeveralPredicatesUsingBooleanOperators() {
        Predicate<Integer> isZero = Predicates.equalTo(0);
        Predicate<Integer> isNotZero = Predicates.not(isZero);
        Predicate<Integer> isNotNull = Predicates.notNull();
        Predicate<Integer> isNull = Predicates.isNull();
        Predicate<Integer> isNotNullAndZero = Predicates.and(isNotNull,isNotZero);
        Predicate<Integer> isNullOrZero = Predicates.or(isNull, isZero);

        assertThat(isNullOrZero.test(null)).isTrue();
        assertTrue(isNullOrZero.test(0));
        assertTrue(isNotNullAndZero.test(10));
        assertFalse(isNotNullAndZero.test(null));
    }
    
}
