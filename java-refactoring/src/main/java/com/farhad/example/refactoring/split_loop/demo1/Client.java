package com.farhad.example.refactoring.split_loop.demo1;

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
        int youngest = Integer.MAX_VALUE;
        double totalsummary = 0;
        for (Person person : people) {
            if(person.getAge() < youngest){
                youngest = person.getAge();
            }
            totalsummary += person.getSalary();
        }
        return new Summary(youngest, totalsummary);
    }
}
