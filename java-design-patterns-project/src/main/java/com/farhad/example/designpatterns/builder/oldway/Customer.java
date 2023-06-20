package com.farhad.example.designpatterns.builder.oldway;

import lombok.Data;

@Data
public class Customer {
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
}
