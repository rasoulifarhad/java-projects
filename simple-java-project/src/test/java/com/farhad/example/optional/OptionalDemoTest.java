package com.farhad.example.optional;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

@Slf4j
public class OptionalDemoTest {
    
    OptionalDemo optionalDemo ;

    @BeforeEach
    public void setup() {
        log.info("setup");
        optionalDemo = new OptionalDemo();
    }

    @AfterEach
    public void tearDown() {
        log.info("tearDown");
        optionalDemo = null;
    }

    @Test
    public void ofNullableTest() {

        Faker faker = new Faker();
        String rawName = faker.name().firstName();
        Optional<String> optional = Optional.ofNullable(
                            optionalDemo.tokenizeName(rawName));
        log.info("{}", optional.toString());
    }

    @Test
    public void isPresentTrueTest() {

        Faker faker = new Faker();
        String name = faker.name().firstName();

        Optional<String> optional = Optional.of(name);
        if(optional.isPresent()) {
            log.info("isPresent true: {}", optional.get());
        } else{
            log.info("isPresent false");
        }
    }

    @Test
    public void isEmptyFalseTest() {

        Optional<String> optional = Optional.empty();
        if(optional.isPresent()) {
            log.info("isPresent true: {}", optional.get());
        } else{
            log.info("isPresent false");
        }
    }

    @Test
    public void isPresentWithConsumerTest() {

        Faker faker = new Faker();
        String rawName = faker.name().firstName();
        Optional<String> optional = Optional.ofNullable(
                            optionalDemo.tokenizeName(rawName));
        optional.ifPresent(s -> log.info("String: {}, Length: {}", s, s.length()));
    }

    @Test
    public void orElseTest() {

        Faker faker = new Faker();
        String rawName = faker.name().firstName();
        String name = Optional.ofNullable(
                                    optionalDemo.tokenizeName(rawName))
                              .orElse("NO_NAME_AVAILABLE");
        log.info("{}", name);
    }

    @Test
    public void orElseGetTest() {

        Faker faker = new Faker();
        String rawName = faker.name().firstName();
        String name = Optional.ofNullable(
                                    optionalDemo.tokenizeName(rawName))
                              .orElseGet(() -> "NO_NAME_AVAILABLE");
        log.info("{}", name);
    }

    @Test
    public void orElseGetVsOrElseWhenEmptyTest() {
        String name = null;
        String nameOrdefaultName = Optional.ofNullable(name).orElse(getDefaultName());
        log.info("{}", nameOrdefaultName);
        nameOrdefaultName = Optional.ofNullable(name).orElseGet(() -> getDefaultName());
        log.info("{}", nameOrdefaultName);
    }

    @Test
    public void orElseGetVsOrElseWhenPresentTest() {
        String name = "Some Name";
        String nameOrdefaultName = Optional.ofNullable(name).orElse(getDefaultName());
        log.info("{}", nameOrdefaultName);
        nameOrdefaultName = Optional.ofNullable(name).orElseGet(() -> getDefaultName());
        log.info("{}", nameOrdefaultName);
    }

    private String getDefaultName() {
        log.info("Getting default name!");
        return "Farhad Rasouli";
    }

}
