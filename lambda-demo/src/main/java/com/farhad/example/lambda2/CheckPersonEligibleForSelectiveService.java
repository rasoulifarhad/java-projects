package com.farhad.example.lambda2;

public class CheckPersonEligibleForSelectiveService implements CheckPerson {

    @Override
    public boolean test(Person person) {
        return person.gender == Person.Sex.MALE && 
                person.getAge() >= 18 &&
                person.getAge() < 25 ;
    }
    
}
