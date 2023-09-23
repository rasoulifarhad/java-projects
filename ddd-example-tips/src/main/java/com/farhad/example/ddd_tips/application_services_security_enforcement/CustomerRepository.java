package com.farhad.example.ddd_tips.application_services_security_enforcement;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findById(CustomerId customerId);

    Customer save(Customer customer);

}
