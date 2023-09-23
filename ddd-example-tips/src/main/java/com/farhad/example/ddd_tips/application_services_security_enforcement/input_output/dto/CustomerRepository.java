package com.farhad.example.ddd_tips.application_services_security_enforcement.input_output.dto;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

}
