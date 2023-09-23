package com.farhad.example.ddd_tips.application_services_security_enforcement.input_output.dpo;

public interface CustomerRepository {

    Customer findById(CustomerId customerId);

}
