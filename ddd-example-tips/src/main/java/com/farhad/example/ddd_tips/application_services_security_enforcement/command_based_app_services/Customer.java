package com.farhad.example.ddd_tips.application_services_security_enforcement.command_based_app_services;

import com.farhad.example.ddd_tips.entities.persons.EmailAddress;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
   
    private  String name;
    private  PostalAddress address;
    private  PhoneNumber phone;
    private  EmailAddress email;    
    
}
