package com.farhad.example.guava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.farhad.example.guava.GuavaCoreDemo.Cake;
import com.farhad.example.guava.GuavaCoreDemo.Customer;
import com.farhad.example.guava.GuavaCoreDemo.Ingredients;
import com.farhad.example.guava.GuavaCoreDemo.IngredientsFactory;
import com.farhad.example.guava.GuavaCoreDemo.Person;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Throwables;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
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

    @Test
    public void demonstrateJoiner() {
        String joined = Joiner.on(",")
                            .skipNulls()
                            .join("One", null, "Two", "Three");
        assertThat(joined).isEqualTo("One,Two,Three");

        assertThrows(NullPointerException.class, () -> 
                        Joiner.on(",")
                            .join("One", null, "Two", "Three"));

        joined = Joiner.on(",")
                    .useForNull("NULL")
                    .join("One", null, "Two", "Three");
        assertThat(joined).isEqualTo("One,NULL,Two,Three");
    }

    @Test
    public void demonstrateSplitter() {
        Iterable<String> strs =  Splitter.on("|")
                    .omitEmptyStrings()
                    .split("One||Two|Three");
        assertThat(strs).hasSize(3);
        assertThat(Iterables.elementsEqual(strs, Lists.newArrayList("One", "Two", "Three"))).isTrue();

        strs = Splitter.on("|")
                    .split("One||Two  |Three");
        log.info("{}", strs);
        assertThat(strs).hasSize(4);
        assertTrue(Iterables.elementsEqual(strs,Lists.newArrayList("One", "", "Two  ", "Three") ));
    }

    private static final String INPUT1 = "_12-34==56";
    private static final String INPUT2 = "12_34-56_78";
    // Utility Object pattern
    // what does it consider a matching character?
    // what do we do with these matching characters?
    @Test
    public void demonstrateCharMatcher() {
        String sanitized = CharMatcher
                                .anyOf("-=_")
                                .removeFrom(INPUT1);
        assertThat(sanitized).isEqualTo("123456");
        sanitized = CharMatcher.whitespace()
                        .replaceFrom("12 34  56", "_");
        assertThat(sanitized).isEqualTo("12_34__56");
        sanitized = CharMatcher
                        .any()
                        .replaceFrom("123456", "*");
        assertThat(sanitized).isEqualTo("******");
        int count = CharMatcher
                        .is('_')
                        .countIn("12_34_56");
        assertThat(count).isEqualTo(2);
        int noneDigitCount = CharMatcher
                                .noneOf("0123456789")
                                .countIn(INPUT1);
        assertThat(noneDigitCount).isEqualTo(4);
        sanitized = CharMatcher
                        .anyOf("0123456789")
                        .retainFrom(INPUT1);
        assertThat(sanitized).isEqualTo("123456");
        sanitized = CharMatcher
                        .anyOf("0123456789")
                        .collapseFrom(INPUT1, 'D');
        assertThat(sanitized).isEqualTo("_D-D==D");
        int lastIndex = CharMatcher
                            .is('_')
                            .lastIndexIn(INPUT2);
        assertThat(lastIndex).isEqualTo(8);
        int index = CharMatcher
                        .is('_')
                        .indexIn(INPUT2);
        assertThat(index).isEqualTo(2);
        sanitized = CharMatcher
                        .digit()
                        .or(CharMatcher.is('-'))
                            .retainFrom(INPUT2);
        assertThat(sanitized).isEqualTo("1234-5678");
        sanitized = CharMatcher
                        .whitespace()
                        .trimAndCollapseFrom("  Hello    World!    , Are you         okay?    ", ' ');
        assertThat(sanitized).isEqualTo("Hello World! , Are you okay?");
        sanitized = CharMatcher
                        .javaDigit()
                        .replaceFrom("123456", '*');
        assertThat(sanitized).isEqualTo("******");
        sanitized = CharMatcher
                        .inRange('0', '9')
                        .retainFrom(INPUT1);
        assertThat(sanitized).isEqualTo("123456");
        sanitized = CharMatcher
                        .inRange('0', '9')
                        .negate()
                        .retainFrom(INPUT1);
        assertThat(sanitized).isEqualTo("_-==");
    }   

    @Test
    public void demonstrateCharsets() {
        try {
            byte [] bytes = "Hello World!".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }

        // do this instead
        byte [] bytes = "Hello World!".getBytes(Charsets.UTF_8);
    }

    @Test
    public void demonstrateCaseFormat() {
        String sanitized = CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL,"hello-world");
        assertThat(sanitized).isEqualTo("helloWorld");

        sanitized = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sanitized);
        assertThat(sanitized).isEqualTo("hello_world");
    }

    /**
     * Many collections, including the JDK's Queue and ConcurrentMap implementations, don't allow null elements.
     * Queue<Optional<Foo>> is a simple and natural solution!
     */
    @Test
    public void demonstrateOptional() {
        Optional<String> nickname = Optional.of("farhad");
        assertTrue(nickname.isPresent());

        nickname = Optional.absent();
        assertFalse(nickname.isPresent());

        assertThrows(NullPointerException.class, 
                    () -> Optional.of(null));
        
        log.info("");
        Person person = Person.builder()
                                .name("Farhad")
                                .build();
        nickname = person.getNickname();
        log.info("{}", (nickname.isPresent() 
                        ? "Hello " + nickname.get()  
                        : person.getName() + " havent nickname!" ));
        assertThat(nickname.or(person.getName())).isEqualTo(person.getName());

        log.info("");
        person = Person.builder()
                                .name("Farhad")
                                .build();
        nickname = person.getNickname();
        boolean haveNickname = false;
        for(String actualNickname : nickname.asSet()) {
            log.info("nickname: {}", actualNickname);
            haveNickname = true;
        }
        log.info("{}", haveNickname ? person.getName() + "( "+ nickname.get() + ")" : person.getName() + " have not nickname");

        log.info("");
        person = Person.builder()
                                .name("Farhad")
                                .nickname("fery")
                                .build();
        nickname = person.getNickname();
        for(String actualNickname : nickname.asSet() ) {
            log.info("nickname: {}", actualNickname);
        }
    }

    @Test
    public void demonstrateStopwatch(){
        Stopwatch watch = Stopwatch.createStarted();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long mili = watch.elapsed(TimeUnit.MILLISECONDS);
        log.info("Elapsed time: {} ms", mili);
        log.info("stopwatch: {} ", watch.toString());
    }

    @Test
    public void demonstrateStrings() {
        String repeatedH5Time = Strings.repeat("H", 5);
        log.info("{}", repeatedH5Time);
        assertThat(repeatedH5Time).isEqualTo("HHHHH");
        
        assertThat(
            Strings.commonPrefix("Hello world", 
                                "Hellllllllll")).isEqualTo("Hell");

        assertNull(Strings.emptyToNull(""));
        assertEquals("", Strings.nullToEmpty(null));
        assertTrue(Strings.isNullOrEmpty(""));
        assertTrue(Strings.isNullOrEmpty(null));
        assertEquals("HiHiHi", Strings.repeat("Hi", 3));
        assertEquals("Hi            ", Strings.padEnd("Hi", 14, ' '));
    }

    @Test
    public void demonstrateToStringAndHashCodes() {
        Customer farhad = new Customer(1L, "Farhad");
        Customer amir = new Customer(2L, "Amir");
        Customer shirin = new Customer(3L, "Shirin");
        Customer ali = new Customer(null, "Ali");

        Object [] farhadAndAmir = new Object [] {farhad, amir};
        int hashCode = Objects.hashCode(farhad, amir);
        assertEquals( Arrays.hashCode(farhadAndAmir), hashCode );

        String toString = MoreObjects.toStringHelper(farhad)
                                .add("name", farhad.getName())
                                .add("id", farhad.getId()).toString();
        assertEquals( "Customer{name=Farhad, id=1}", toString);

        Long defaultId = null;
        Long aliId = ali.getId() != null ? ali.getId() : defaultId ;

        assertThrows(
            NullPointerException.class, 
            () -> {
                long aliId2 = MoreObjects.firstNonNull(ali.getId(), defaultId);
                assertEquals(0, aliId2);
            });
    }

    @Test
    public void demonstratePreconditions() {

        Customer shirin = new Customer(3L, "Shirin");
        shirin.setSick(true);

        Customer ali = new Customer(null, "Ali");

        assertDoesNotThrow(
            () -> Preconditions.checkNotNull(shirin.getId()));

        assertThrows(
            NullPointerException.class, 
            () -> Preconditions.checkNotNull(ali.getId()));

        assertThrows(
            IllegalStateException.class, 
            () -> Preconditions.checkState(!shirin.isSick()));

        assertThrows(
            IllegalArgumentException.class, 
            () -> Preconditions.checkArgument(
                        shirin.getAddress() != null, 
                        "Address is null for %s", 
                        shirin.getId() ));
    }

    @Test
    public void demonstrateFunctionsForFun() {

        Customer farhad = new Customer(1L, "Farhad");
        Customer amir = new Customer(2L, "Amir");

        Function<Customer, Boolean> isCustomerWithOddId = new Function<Customer,Boolean>() {

            @Override
            public Boolean apply(Customer customer) {
                return customer.getId().intValue() % 2 == 0;
            }
        };

        assertTrue(isCustomerWithOddId.apply(amir));
        assertFalse(isCustomerWithOddId.apply(farhad));
    }

    @Test
    public void demonstratePredicatesWithCustomer() {

        Customer farhad = new Customer(1L, "Farhad");
        Customer amir = new Customer(2L, "Amir");
        Customer shirin = new Customer(3L, "Shirin");

        ImmutableSet<Customer> customers = ImmutableSet.of(farhad, amir, shirin);

        Predicate<Customer> itsFarhad = Predicates.equalTo(farhad);
        Predicate<Customer> itsAmir = Predicates.equalTo(amir);
        Predicate<Customer> farhadOrAmir = Predicates.or(itsFarhad, itsAmir);
        // Predicate<Customer> itsShirin = Predicates.equalTo(shirin);
        Iterable<Customer> filtered = Iterables.filter(customers, farhadOrAmir);
        assertEquals(2, ImmutableSet.copyOf(filtered).size());
    }

    // Suppliers.compose( Function<T, R>, Supplier<T> ) --> Supplier<R>
    @Test
    public void demonstrateSuppliersWithIngredientsAndCake() {
        IngredientsFactory factory = new IngredientsFactory();

        Supplier<Cake> cakeFactory = Suppliers.compose(bake(), factory);
        cakeFactory.get();
        cakeFactory.get();
        assertEquals(2, factory.getNumberOfIngredientsUsed());
    }

    private Function<Ingredients, Cake> bake() {
        return new Function<Ingredients,Cake>() {

            @Override
            public Cake apply(Ingredients ingredients) {
                return new Cake(ingredients);
            }
        };
    }

    @Test
    public void demonstrateThrowablesOldWay() {
        try {
            
            try {
                mayThrowAnything();
            } catch ( IKnowWhatToDoWithThisException e) {
                handle(e);
            } catch (Throwable e) {
                if (e instanceof ClassCastException) {
                    throw e; // Old way
                }
                Throwables.throwIfInstanceOf(e, NumberFormatException.class); // same as
                Throwables.throwIfUnchecked(e);
                throw new RuntimeException(e);
            }

        } catch (RuntimeException e) {
            List<Throwable> throwables = Throwables.getCausalChain(e);
            log.info("");
            log.info("Causal Chain: {}", throwables);
            log.info("");
            log.info("Root cause: {}", Throwables.getRootCause(e));
            log.info("");
            log.info("{}", Throwables.getStackTraceAsString(e));
        }
    }

    private void mayThrowAnything() {
        Integer.parseInt("abc");
    }

    private void handle(IKnowWhatToDoWithThisException e) {
        log.info("Handled!!!: {}", e);
    }

    private static class IKnowWhatToDoWithThisException extends RuntimeException {
 
    }

    @Test 
    public void demonstrateAnotherJoiner() {
        List<String> heroes = Lists.newArrayList("Kick-Ass", "Iron Man", "Chuck Norris");
        String names = Joiner.on(",").join(heroes);
        log.info("{}", names);
        assertThat(names).isEqualTo("Kick-Ass,Iron Man,Chuck Norris");

        List<String> heroesWithNull = Lists.newArrayList("Kick-Ass", "Iron Man", null, "Chuck Norris");
        assertThrows(
            NullPointerException.class,
            () -> Joiner.on(",").join(heroesWithNull) );

        names = Joiner.on(",").skipNulls().join(heroesWithNull);
        assertThat(names).isEqualTo("Kick-Ass,Iron Man,Chuck Norris");

        names = Joiner.on(",").useForNull("Invisible Man").join(heroesWithNull);
        assertThat(names).isEqualTo("Kick-Ass,Iron Man,Invisible Man,Chuck Norris");
    }

    @Test
    public void demonstrateMapJoiner() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Kick-Ass");
        map.put(2, "Iron Man");
        map.put(3, "Chuck Norris");
        String expectedRanks = "1->Kick-Ass\n2->Iron Man\n3->Chuck Norris";
        String ranks = Joiner.on("\n").withKeyValueSeparator("->").join(map);
        System.out.println( ranks);
        assertThat(expectedRanks).isEqualTo(ranks);
    }
}
