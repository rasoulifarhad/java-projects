package com.farhad.example.lambda2;

public class CheckAllPerson implements CheckPerson {

    @Override
    public boolean test(Person person) {
        return true;
    }
    
}
