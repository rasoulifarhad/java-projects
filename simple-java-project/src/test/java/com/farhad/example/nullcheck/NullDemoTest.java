package com.farhad.example.nullcheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Java Optional Example Badly Done
 */
@Slf4j
public class NullDemoTest {
    
    @Test
    public void equalsNullPointerException() {
        String color = null;
        assertThrows(NullPointerException.class, 
                                () -> color.equals("RED"));
    }

    @Test
    public void equalsNoException() {
        String color = null;
        boolean isRed = "RED".equals(color);
        assertThat(isRed).isFalse();
    }

    @Test
    public void declareBadlyCustomerFillingJustMandatoryFields() {
        final BadlyCustomer customer = new BadlyCustomer(
                "Farhad", 
                "Rasouli", 
                Optional.empty(), 
                Optional.empty(), 
                Optional.empty(), 
                Optional.empty());

        log.info("Customer address: {}", customer.getAddress().orElse("No address available"));
    }
    
    @Test
    public void declareBadlyCustomerFillingAllFields() {
        final BadlyCustomer customer = new BadlyCustomer(
            "Farhad", 
            "Rasouli", 
            Optional.of(45), 
            Optional.of("Tehran"), 
            Optional.of("123456"), 
            Optional.of(Sex.MALE));

        log.info("Customer address: {}", customer.getAddress().orElse("No address available"));
    }

    @Test
    public void declareBadlyCustomerFillingSomeFieldsNull() {
        final BadlyCustomer customer = new BadlyCustomer(
            "Farhad", 
            "Rasouli", 
            Optional.of(45), 
            null, 
            null, 
            Optional.of(Sex.MALE));

        assertThrows(
                NullPointerException.class, 
                () -> log.info("Customer address: {}", customer.getAddress().orElse("No address available")));
    }

    @Test
    public void declareCustomer() {
        final Customer customer = 
                Customer
                    .builderOf("Farhad", "Rasouli")
                        .withAge(45)
                        .build();

        log.info("Customer address: {}", customer.getAddress().orElse("No address available"));
    }


    @AllArgsConstructor
    @Data
    static class BadlyCustomer {
        private final String firstName;
        private final String surname;
        private final Optional<Integer> age;
        private final Optional<String> address;
        private final Optional<String> phoneNumber;
        private final Optional<Sex> sex;
    }

    static enum Sex {
        MALE, FEMALE
    }

    @Data
    static class Customer {

        private final String name;
        private final String surname;
        private final Integer age;
        private final String address;
        private final String phoneNumber;
        private final Sex  sex;

        private Customer(Builder builder) {
            this.name = builder.name;
            this.surname = builder.surname;
            this.age = builder.age;
            this.address = builder.address;
            this.phoneNumber = builder.phoneNumber;
            this.sex = builder.sex;
        }

        public static Builder builderOf(String name, String surname) {
            return new Builder(name, surname);
        }

        static class Builder {

            private final String name;
            private final String surname;
            private Integer age;
            private String address;
            private String phoneNumber;
            private Sex  sex;

            private Builder(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            public Builder withAddress(String address) {
                this.address = address;
                return this;
            }

            public Builder withAge(Integer age) {
                this.age = age ;
                return this;
            }

            public Builder withPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
                return this;
            }

            public Builder withSex(Sex sex) {
                this.sex = sex;
                return this;
            }

            public Customer build() {
                return new Customer(this);
            }
        }

        public Optional<Integer> getAge() {
            return Optional.ofNullable(age);
        }

        public Optional<String> getAddress() {
            return Optional.ofNullable(address);
        }

        public Optional<String> getPhoneNumber() {
            return Optional.ofNullable(phoneNumber);
        }

        public Optional<Sex> getSex() {
            return Optional.ofNullable(sex);
        }
    }
}
