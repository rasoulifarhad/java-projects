package com.farhad.example.refactoring.split_loop.demo2;

import java.util.stream.Stream;

public class Client {

    private static final Client CLIENT = new Client();
    private Client() {

    }

    public static Client client() {
        return CLIENT;
    }
    public static void main(String[] args) {
        Client client = client();
        Person[] peaple = new Person[0];
        client.summary(peaple);

    }

    public Summary summary(Person[] people) {
        return new Summary(youngestAge(people), totalsummary(people));
    }

    private int youngestAge(Person[] people) {
        return Stream.of(people)
            .mapToInt(p -> p.getAge())
            .min()
            .getAsInt();
    }

    private double totalsummary(Person[] people) {
        return Stream.of(people)
            .mapToDouble(p -> p.getSalary())
            .reduce(0, (left, right) -> left + right);
    }
}
