package com.farhad.example.ddd_tips.application_services_security_enforcement.input_validation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class EntityValidationJSR303Demo {
    
    public static class CustomerNo {

    }

    public static class PostalAddress {

    }    
    public static class Customer {

    @NotNull // <1>
    private CustomerNo customerNo;

    @NotBlank // <2>
    @Size(max = 50) // <3>
    private String name;

    @NotNull
    private PostalAddress address;        
    }
}
