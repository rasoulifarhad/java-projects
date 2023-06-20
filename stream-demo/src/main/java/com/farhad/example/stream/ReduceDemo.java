package com.farhad.example.stream;

import static com.farhad.example.stream.collectors.person.Person.persons;

import java.util.List;

import com.farhad.example.stream.collectors.person.Person;

import lombok.extern.slf4j.Slf4j;

/**
 * The reduction operation combines all elements of the stream into a single result. 
 * 
 * - Reduces a stream of elements to exactly one element of the stream. (accepts a BinaryOperator accumulator function)
 * - Accepts both an identity value and a BinaryOperator accumulator. 
 * - Accepts three parameters: an identity value, a BiFunction accumulator and a combiner function of type BinaryOperator. 
 */
@Slf4j
public class ReduceDemo {

    /**
     * Optional<T> reduce(BinaryOperator<T> accumulator);
     * 
     * Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an `Optional` describing 
     * the reduced value, if any. 
     * 
     * This is equivalent to:
     * 
     *  boolean foundAny = false;
     *  T result = null;
     *  for (T element : this stream) {
     *     if (!foundAny) {
     *         foundAny = true;
     *         result = element;
     *     }
     *     else
     *         result = accumulator.apply(result, element);
     *  }
     *  return foundAny ? Optional.of(result) : Optional.empty();
     *  }
     * 
     */
    public void demonstrateOldestPersonWithReduce() {
        log.info("");
        List<Person> personList = persons();
        personList
            .stream()
            .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
            .ifPresent(p -> log.info("Oldest person: {}", p));
    }

    /**
     *  T reduce(T identity, BinaryOperator<T> accumulator);
     * 
     *  is equivalent to:
     *  
     *  T result = identity;
     *  for (T element : this stream)
     *     result = accumulator.apply(result, element)
     *  return result;
     * 
     * The identity value must be an identity for the accumulator function. This means that for all t, accumulator.apply(identity, t) 
     * is equal to t. The accumulator function must be an associative function.
     */
    public void demonstrateConstructPersonWithAggregatedNamesAndAgesOfAllPersons() {
        log.info("");
        List<Person> personsList = persons();
        Person result = 
                    personsList
                        .stream()
                        .reduce(
                            new Person("", 0), 
                            (p1, p2) -> {
                                p1.setAge(p1.getAge() +  p2.getAge() );
                                p1.setName(  p1.getName() + p2.getName());
                                return p1;
                            });
        log.info("Name: {}; Age:{}", result.getName(), result.getAge());
    }

    public void demonstrateDetermineSumOfAgesFromAllPersons() {
        log.info("");
        List<Person> personList = persons();
        Integer ageSum = personList
                            .stream()
                            // .reduce(0, 
                            //     (sum, p) -> sum += p.getAge(), 
                            //     (sum1, sum2) -> sum1 + sum2);
                            .reduce(
                                0, 
                                (sum, p) -> {
                                    log.info("accumulator: sum={}; person={}", sum, p);
                                    return sum += p.getAge();
                                }, 
                                (sum1, sum2) -> {
                                    log.info("combiner: sum1={}; sum2={}", sum1, sum2);
                                    return sum1 + sum2;
                                });
        log.info("Sum of ages: {}", ageSum);
    }

    public void demonstrateDetermineSumOfAgesFromAllPersonsWithParallelStream() {
        log.info("");
        List<Person> personList = persons();
        Integer ageSum = personList
                            .parallelStream()
                            .reduce(
                                Integer.valueOf(0), 
                                (sum, p) -> {
                                    log.info("accumulator: sum={}; person={}", sum, p);
                                    return sum += p.getAge();
                                }, 
                                (sum1, sum2) -> {
                                    log.info("combiner: sum1={}; sum2={}", sum1, sum2);
                                    return sum1 + sum2;
                                });
        log.info("Sum of age: {}", ageSum);
    }

    public static void main(String[] args) {
        ReduceDemo demo = new ReduceDemo();

        demo.demonstrateOldestPersonWithReduce();
        demo.demonstrateConstructPersonWithAggregatedNamesAndAgesOfAllPersons();
        demo.demonstrateDetermineSumOfAgesFromAllPersons();
        demo.demonstrateDetermineSumOfAgesFromAllPersonsWithParallelStream();
    }
}
