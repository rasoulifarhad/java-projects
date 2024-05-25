package com.farhad.example.functional_interface.solid.srp.funtional;

public class App {

    public static void main(String[] args) {
        Prime prime = new Prime();

        System.out.println(prime.countPrimes(20_000));
    }
}
