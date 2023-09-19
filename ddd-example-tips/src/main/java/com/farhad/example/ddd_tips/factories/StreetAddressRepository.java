package com.farhad.example.ddd_tips.factories;

public interface StreetAddressRepository {

    StreetAddress findByPostOfficeAndName(PostOffice postOffice, String streetAddress);
    
}
