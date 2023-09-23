package com.farhad.example.ddd_tips.application_services_security_enforcement.command_based_app_services;

import javax.transaction.Transactional;

public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomerCommand, Customer> {

    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer handleCommand(CreateCustomerCommand command) {

        Customer customer = new Customer();
        customer.setName(command.getName());
        customer.setAddress(command.getAddress());
        customer.setPhone(command.getPhone());
        customer.setEmail(command.getEmail());
        return customerRepository.save(customer);    }
    
}
