package com.farhad.example.lambda2;

/**
 * The CheckPerson interface is a functional interface. A functional interface is any interface that contains only one abstract method. 
 * (A functional interface may contain one or more default methods or static methods.) 
 */
public interface CheckPerson {
    boolean test(Person person);
}
