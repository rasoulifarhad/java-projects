package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.Iiritating_parameter.better;

// One of the many responsibilities of this class is to tell us whether customers
// have valid credit. If they do, we get back a certiﬁcate that tells us how much
// credit they have. If they don’t, the class throws an exception.
//
// Our mission, it is to add a new method to this class. The method will be named 
// getValidationPercent , and its job will be to tell us the percentage of successful 
// validateCustomer calls we’ve made over the life of the validator .
public class CreditValidator {

    private IRGHConnection connection;
    private CreditMaster master;
    private String validatorId;

    public CreditValidator(IRGHConnection connection,
                           CreditMaster master,
                           String validatorId) {
                            this.connection = connection;
                            this.master = master;
                            this.validatorId = validatorId;

    }

    Certificate validateCustomer(Customer customer) throws InvalidCredit {
        //
        RFIDReport rfidReport = connection.RFDIReportFor(customer.getId());
        //
        //
        Certificate certificate = new Certificate();
        //
        //
        return certificate;
    }

    public Double getValidationPercent() {
        return 0.0;
    }
}
