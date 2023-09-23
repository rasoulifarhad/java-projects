package com.farhad.example.ddd_tips.application_services_security_enforcement;

import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.stereotype.Service;


// 1. The application service method runs inside a transaction.
// 2. The application service method can be accessed by any user.
// 3. We invoke a JSR-303 validator to check that the incoming registration request contains all the necessary information. If the request is invalid, we throw an exception that will be reported back to the user.
// 4. We invoke a domain service that will check if there already is a customer in the database with the same information. If that is the case, the domain service will throw an exception (not shown here) that will be propagated back to the user.
// 5. We invoke a domain factory that will create a new Customer aggregate with information from the registration request object.
// 6. We invoke a domain repository to save the customer and returns the newly created and saved customer aggregate root.


@Service
public class CustomerRegistrationService {
    
    private Validator validator;
    private CustomerDuplicateLocator customerDuplicateLocator;
    private CustomerFactory customerFactory;
    private CustomerRepository customerRepository;

    @Transactional // <1>
    @PermitAll  // <2>
    public Customer registerNewCustomer(CustomerRegistrationRequest request) {
        Set<ConstraintViolation<CustomerRegistrationRequest>>  violations = validator.validate(request); // <3>
        if(violations.size() > 0 ){
            throw new InvalidCustomerRegistrationRequest(violations);
        }
        customerDuplicateLocator.checkForDuplicates(request); // <4>
        Customer customer = customerFactory.createNewCustomer(request); // <5>
        return customerRepository.save(customer); // <6>
    }    
}
