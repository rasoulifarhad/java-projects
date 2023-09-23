package com.farhad.example.ddd_tips.application_services_security_enforcement;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class InvalidCustomerRegistrationRequest extends RuntimeException {

    public InvalidCustomerRegistrationRequest(Set<ConstraintViolation<CustomerRegistrationRequest>> violations) {
    }

}
