package com.farhad.example.refactoring.static_substitution.refactored;

public class Client {

    public static void main(String[] args) {
        
        AddressBook.loadInstance(new StubAddressBook());
        AddressBook.findByLastName("lastName#1");
    }
}
