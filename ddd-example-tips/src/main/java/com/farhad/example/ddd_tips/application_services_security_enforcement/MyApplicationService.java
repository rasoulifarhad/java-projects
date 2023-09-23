package com.farhad.example.ddd_tips.application_services_security_enforcement;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

// 
// 1. The annotation instructs the framework to only allow authenticated users with the role ROLE_BUSINESS_PROCESSOR 
//    to invoke the method.
// 2. The application service looks up an aggregate root from a repository in the domain model.
// 3. The application service passes the aggregate root to a domain service in the domain model, storing the result 
//    (whatever it is).
// 4. The application service uses the result of the domain service to update the business process object and returns 
//    it so that it can be passed to other application service methods participating in the same longrunning process.
//
@Service
@RequiredArgsConstructor
public class MyApplicationService {
    
    private final CustomerRepository customerRepository;
    private final MyDomainService myDomainService;

    @Secured("ROLE_BUSINESS_PROCESSOR") // 1
    public MyBusinessProcess performSomeStuff(MyBusinessProcess input) {
        Customer customer = 
                customerRepository.findById(input.getCustomerId())
                            .orElseThrow(() -> new CustomerNotFoundException(input.getCustomerId())) ; // 2
        SomeResult someResult = myDomainService.performABusinessOperation(customer); //3
        customer = customerRepository.save(customer);
        return input.updateMyBusinessProcessWithResult(someResult); // 4
    }


}
