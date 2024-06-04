package com.farhad.example.refactoring.split_loop.demo2;

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
        double totalsummary = totalsummary(people);
        int youngest = youngestAge(people);
        return new Summary(youngest, totalsummary);
    }

    private int youngestAge(Person[] people) {
        int youngest = Integer.MAX_VALUE;
        for (Person person : people) {
            if(person.getAge() < youngest){
                youngest = person.getAge();
            }
        }
        return youngest;
    }

    private double totalsummary(Person[] people) {
        double totalsummary = 0;
        for (Person person : people) {
            totalsummary += person.getSalary();
        }
        return totalsummary;
    }
}
