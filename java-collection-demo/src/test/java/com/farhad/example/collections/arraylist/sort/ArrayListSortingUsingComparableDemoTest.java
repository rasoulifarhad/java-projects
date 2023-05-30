package com.farhad.example.collections.arraylist.sort;

import static net.datafaker.transformations.Field.field;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.collections.arraylist.sort.ArrayListSortingUsingComparableDemo.Person;
import com.farhad.example.collections.arraylist.sort.ArrayListSortingUsingComparableDemo.PersonSorter;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import net.datafaker.transformations.JavaObjectTransformer;
import net.datafaker.transformations.Schema;

@Slf4j
public class ArrayListSortingUsingComparableDemoTest {
    
    private List<Person>  persons;
    private PersonSorter personSorter;

    @BeforeEach
    public void setup() {
        Faker faker = new Faker() ;
        persons = IntStream.range(1, 5)
                            .mapToObj(operand -> {
                                        Schema<Object,?> schema = Schema.of(
                                            field("id", () -> faker.number().positive()),
                                            field("firstName", () -> faker.name().firstName()),
                                            field("lastName", () -> faker.name().lastName()),
                                            field("gender", () -> faker.gender().shortBinaryTypes()),
                                            // field("birthDate", () -> faker.date().birthday()),
                                            field("age", () -> faker.number().numberBetween(35, 95)));
                                        JavaObjectTransformer jTransformer = new JavaObjectTransformer();
                                        Person person =(Person) jTransformer.apply(Person.class, schema);
                                        return person;
                            })
                            .collect(Collectors.toList());
        personSorter = new PersonSorter(persons);
    }

    @AfterEach
    public void tearDown() {
        persons = null;
        personSorter = null;
    }

    @Test
    public void sortPapersByAgeTest() {
        

        log.info("{} Befor sort", persons.stream().map(person -> person.getAge() ).collect(Collectors.toList()));
        List<Person> sortedPersons = personSorter.sortByAge();
        log.info("{} After sort by age ascending", sortedPersons.stream().map(person -> person.getAge() ).collect(Collectors.toList()));

    }
}
