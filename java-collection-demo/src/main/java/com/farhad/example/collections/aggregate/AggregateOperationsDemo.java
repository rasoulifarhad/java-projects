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

    public void demonstrateGroupPersonsByGender() {
        List<Person> roster = Person.createRoster();
        log.info("");
        Map<Sex, List<Person>> byGender = roster
                                            .stream()
                                            .collect(Collectors.groupingBy(Person::getGender));
        byGender.entrySet()
                    .forEach(entry -> log.info("{}: {} ", entry.getKey(), entry.getValue()));
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
    }
}
