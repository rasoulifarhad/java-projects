package com.farhad.example.anotherddd;

public class FeePaidOffHandler implements DomainEvendHandler<FeePaidOff> {

    private CustomerRepository customerRepository;

    public FeePaidOffHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;;
    }

    @Override
    public void handle(FeePaidOff event) {
        Fee fee = event.getFee();
        Customer customer = customerRepository.getCustomerChargedForFee(fee);
        customer.updateAtRiskStatus();
    }
    
}
