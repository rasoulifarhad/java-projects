package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.Iiritating_parameter;

// One of the many responsibilities of this class is to tell us whether customers
// have valid credit. If they do, we get back a certiﬁcate that tells us how much
// credit they have. If they don’t, the class throws an exception.
//
// Our mission, it is to add a new method to this class. The method will be named 
// getValidationPercent , and its job will be to tell us the percentage of successful 
// validateCustomer calls we’ve made over the life of the validator .
public class CreditValidator {

    public CreditValidator(RGHConnection connection,
                           CreditMaster master,
                           String validatorId) {

    }

    Certificate validateCustomer(Customer customer) throws InvalidCredit {
        //
        return new Certificate();
    }
}
