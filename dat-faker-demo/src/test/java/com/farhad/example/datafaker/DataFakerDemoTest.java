package com.farhad.example.datafaker;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

@Slf4j
public class DataFakerDemoTest {

    @Test
    public void demonstrateSimpleDataFaker() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = faker.name().fullName();
        log.info("First Name: {} , Last Name: {} , Full Name: {}", firstName, lastName, fullName);

        log.info("{} , {} , {} , {} , {} , {}", 
                                    faker.address().streetAddress(),
                                    faker.address().streetName(),
                                    faker.address().city(),
                                    faker.address().country(),
                                    faker.address().lonLat(","),
                                    faker.address().zipCode());
        log.info("{}", faker.address().fullAddress());
    }

    @Test
    public void demonstrateFackerExpressions() {
        Faker faker = new Faker();
        log.info("'{}'", faker.expression("#{numerify 'User:##'}"));
        log.info("'{}'", faker.expression("#{numerify '##User'}"));
        log.info("Example generated: '{}'", faker.expression("#{examplify 'xxxxxxxx'}"));
        log.info("Option choosed: '{}'", faker.expression("#{options.option 'One', 'Two', 'Three'}"));
        log.info("Letterify: '{}'", faker.expression("#{letterify '*?-??-???-????#'}"));

        System.out.println("csv:");
        System.out.println( faker.expression("#{csv '2', 'name', '#{Name.first_name}', 'surname', '#{Name.last_name}'"));

        System.out.println("JSON:");
        System.out.println(faker.expression("#{json 'person', '#{json ''full_name'', ''#{Name.full_name}''}'}"));
    }

    @Test
    public void demonstrateFakerCollections() {
        Faker faker = new Faker();

        List<String> names = 
                    faker.collection(() -> faker.name().firstName())
                          .len(3, 6)
                          .generate();
        log.info("Names: {}", names);

        List<String> cities = 
                    faker.collection( () -> faker.address().cityName())
                         .len(3, 6)
                         .generate();
        log.info("Cities: {}", cities);

        List<String> namesAndCities = 
                    faker.collection(
                        () -> faker.name().firstName(),
                        () -> faker.address().cityName()
                    )
                    .len(6)
                    .generate();
        log.info("List of names and cities: {}", namesAndCities);
    }

    @Test
    public void demonstrateFakerStream() {
        Faker faker = new Faker();
        Stream<String> countries = 
                        faker.stream( () -> faker.address().country())
                             .generate();
        List<String> countryList =  countries
                                        .limit(4)
                                        .collect(Collectors.toList());
        log.info("Country List: {}", countryList);

        Stream<String> namesAndCountries = 
                    faker.stream(
                        () -> faker.name().lastName(),
                        () -> faker.address().country()
                    )
                    .len(6)
                    .generate();
        List<String> nameAndCountryList = namesAndCountries
                                                .collect(Collectors.toList());
        log.info("NameAndCountryList: {}", nameAndCountryList);
    }
}
