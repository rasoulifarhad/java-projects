package com.farhad.example.ddd_tips.application_services_security_enforcement.command_based_app_services;

import com.farhad.example.ddd_tips.entities.persons.EmailAddress;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CreateCustomerCommand implements Command<Customer> {
    
    private final String name;
    private final PostalAddress address;
    private final PhoneNumber phone;
    private final EmailAddress email;    
}
