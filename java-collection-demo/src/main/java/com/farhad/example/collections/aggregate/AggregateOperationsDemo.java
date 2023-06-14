package com.farhad.example.collections.aggregate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.farhad.example.collections.aggregate.Person.Sex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AggregateOperationsDemo {
 
    public void demonstratePrintsNamesOfAllPersonsWithForEachLoop() {

        List<Person> roster = Person.createRoster();
        log.info("");
        for (Person person : roster) {
            log.info("Name: {}", person.getName());
        }
    }

    public void demonstratePrintsNamesOfAllPersonsWithAggregateOperationForEach() {

        List<Person> roster = Person.createRoster();
        log.info("");
        roster
            .stream()
            .forEach(p -> log.info("Name: {}", p.getName()));
    }

    /**
     * A pipeline is a sequence of aggregate operations. 
     */
    public void demonstratePrintMalePersonsWithPipeline() {
        List<Person> roster = Person.createRoster();
        log.info("");
        roster
            .stream()
            .filter(p -> p.getGender() == Sex.MALE )
            .forEach(p -> log.info("Name: {}", p.getName()));
    }

    public void demonstrateCalculateAverageAgeOfAllMaleWithPipeline() {
        List<Person> roster = Person.createRoster();
        double averageAgeOfMaleMembers = roster
                                            .stream()
                                            .filter(p -> p.getGender() == Sex.MALE )
                                            .mapToInt(Person::getAge)
                                            .average()
                                            .getAsDouble();
        log.info("");
        log.info("MALE persons average age: {}", averageAgeOfMaleMembers);
    }

    public void demonstrateCalculateSumOfMalePersonsAgeWithSum() {
        List<Person> roster = Person.createRoster();
        log.info("");
        Integer totalAge = roster
                                .stream()
                                .filter(p -> p.getGender() == Sex.MALE )
                                .mapToInt(Person::getAge)
                                .sum();
        log.info("MALE persons sum age: {}", totalAge);
    }

    public void demonstrateCalculateSumOfMalePersonsAgeWithStreamReduce() {
        List<Person> roster = Person.createRoster();
        log.info("");
        Integer totalAge = roster
                                .stream()
                                .filter(p -> p.getGender() == Sex.MALE)
                                .map(Person::getAge)
                                .reduce(0,  (a, b) -> a + b);
        log.info("MALE persons sum age: {}", totalAge);
    }

    /**
     * The collect operation in this example takes three arguments:
     * 
     * - supplier: The supplier is a factory function; it constructs new instances. For the collect operation, it creates instances of the 
     *   result container. In this example, it is a new instance of the Averager class.
     * 
     * - accumulator: The accumulator function incorporates a stream element into a result container. In this example, it modifies the 
     *   Averager result container by incrementing the count variable by one and adding to the total member variable the value of the 
     *   stream element, which is an integer representing the age of a male member.
     * 
     * - combiner: The combiner function takes two result containers and merges their contents. In this example, it modifies an Averager 
     *   result container by incrementing the count variable by the count member variable of the other Averager instance and adding to 
     *   the total member variable the value of the other Averager instance's total member variable.
     */
    public void demonstrateCalculateAverageAgeOfMalePersonsWithStreamCollect() {
        List<Person> roster = Person.createRoster();
        log.info("");
        Averager averageCollect = roster
                                    .stream()
                                    .filter(p -> p.getGender() == Sex.MALE)
                                    .map(Person::getAge)
                                    .collect(Averager::new, Averager::accept, Averager::combine);
        log.info("Average age of male persons: {}", averageCollect.average());
    }


    public void demonstratePersonsNamesWithCollectToList() {
        List<Person> roster = Person.createRoster();
        log.info("");
        List<String> names = roster
                                .stream()
                                .filter(p -> p.getGender() == Sex.MALE)
                                .map(p -> p.getName())
                                .collect(Collectors.toList());
        log.info("names: {}", names);
    }

    /**
     * The groupingBy operation returns a map whose keys are the values that result from applying the lambda expression specified as 
     * its parameter (which is called a classification function).
     * 
     * The keys' corresponding values are instances of List that contain the stream elements that, when processed by the classification 
     * function, correspond to the key value.
     * 
     * For example, the value that corresponds to key Person.Sex.MALE is an instance of List that contains all male members.
     */
    public void demonstrateGroupPersonsByGender() {
        List<Person> roster = Person.createRoster();
        log.info("");
        Map<Sex, List<Person>> byGender = roster
                                            .stream()
                                            .collect(Collectors.groupingBy(Person::getGender));
        byGender.entrySet()
                    .forEach(entry -> log.info("{}: {} ", entry.getKey(), entry.getValue()));
    }

    /**
     * retrieves the names of each member in the collection roster and groups them by gender.
     * 
     * The groupingBy operation in this example takes two parameters, a classification function and an instance of Collector. The 
     * Collector parameter is called a downstream collector. This is a collector that the Java runtime applies to the results of 
     * another collector. Consequently, this groupingBy operation enables you to apply a collect method to the List values created 
     * by the groupingBy operator.  A pipeline that contains one or more downstream collectors, like this example, is called a 
     * multilevel reduction.
     */
    public void demonstrateRetrievePersonNamesGrouppingByGender() {
        List<Person> roster = Person.createRoster();
        log.info("");
        Map<Sex, List<String>> namesByGender = 
                                roster 
                                    .stream()
                                    .collect(Collectors.groupingBy(
                                                Person::getGender,
                                                Collectors.mapping(
                                                    Person::getName, 
                                                    Collectors.toList())));
        namesByGender.entrySet()
                            .forEach(entry -> log.info("{}: {}", entry.getKey(), entry.getValue()));
    }

    /**
     * retrieves the total age of members of each gender:
     * 
     * The reducing operation takes three parameters:
     * 
     * - identity: Like the Stream.reduce operation, the identity element is both the initial value of the reduction and the default 
     *   result if there are no elements in the stream. In this example, the identity element is 0; this is the initial value of the 
     *   sum of ages and the default value if no members exist.
     * 
     * - mapper: The reducing operation applies this mapper function to all stream elements. In this example, the mapper retrieves the 
     *   age of each member.
     * 
     * - operation: The operation function is used to reduce the mapped values. In this example, the operation function adds Integer 
     *   values.

     */
    public void demonstrateRetrieveTotalAgeOfPersonofEachGender() {
        List<Person> roster = Person.createRoster();
        log.info("");
        Map<Sex, Integer> totalAgeByGender = 
                            roster
                                .stream()
                                .collect(
                                    Collectors.groupingBy(
                                        Person::getGender, 
                                        Collectors.reducing(
                                            0, 
                                            Person::getAge, 
                                            Integer::sum)));
        totalAgeByGender.entrySet()
                            .forEach(entry -> log.info("{}: totsl age {} ", entry.getKey(), entry.getValue()));
    }

    public void demonstrateRetrieveAverageAgeOfPersonofEachGender() {
        List<Person> roster = Person.createRoster();
        log.info("");
        Map<Sex, Double> averageAgeByGender = 
                    roster
                    .stream()
                    .collect(Collectors.groupingBy(
                        Person::getGender, 
                        Collectors.averagingInt(Person::getAge)));
        averageAgeByGender.entrySet()
                            .forEach(entry -> log.info("{}: average age {} ", entry.getKey(), entry.getValue()));
    }

    public static void main(String[] args) {
        AggregateOperationsDemo demo = new AggregateOperationsDemo();

        demo.demonstratePrintsNamesOfAllPersonsWithForEachLoop();
        demo.demonstratePrintsNamesOfAllPersonsWithAggregateOperationForEach();
        demo.demonstratePrintMalePersonsWithPipeline();
        demo.demonstrateCalculateAverageAgeOfAllMaleWithPipeline();
        demo.demonstrateCalculateSumOfMalePersonsAgeWithSum();
        demo.demonstrateCalculateSumOfMalePersonsAgeWithStreamReduce();
        demo.demonstrateCalculateAverageAgeOfMalePersonsWithStreamCollect();
        demo.demonstratePersonsNamesWithCollectToList();
        demo.demonstrateGroupPersonsByGender();
        demo.demonstrateRetrievePersonNamesGrouppingByGender();
        demo.demonstrateRetrieveTotalAgeOfPersonofEachGender();
        demo.demonstrateRetrieveAverageAgeOfPersonofEachGender();
    }
}
