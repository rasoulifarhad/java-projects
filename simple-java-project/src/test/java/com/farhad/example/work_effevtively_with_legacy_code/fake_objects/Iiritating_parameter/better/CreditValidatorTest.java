package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.Iiritating_parameter.better;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CreditValidatorTest {

    private static final String THRESHOLD = null;

    @Test
    public void testCreate() throws Exception {
        FakeRGHConnection connection = new FakeRGHConnection();
        CreditMaster master = new CreditMaster("crm2.mas", true);

        CreditValidator validator = new CreditValidator(connection, master, "a");

        connection.report = new RFIDReport();

        Certificate result = validator.validateCustomer(new Customer(1));
        assertEquals(Certificate.VALID, result.getStatus());
    }

    @Test
    public void testCreateNullArgument() throws Exception {
        CreditValidator validator = new CreditValidator(null, null, "a");
    }

    @Test
    public void testAllPassed100Percent() throws Exception {
        FakeRGHConnection connection = new FakeRGHConnection();

        CreditValidator validator = new CreditValidator(connection, null, "a");

        connection.report = new RFIDReport();

        Certificate result = validator.validateCustomer(new Customer(1));
        assertEquals(100.0, validator.getValidationPercent(), THRESHOLD);
    }
}
