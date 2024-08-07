package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.Iiritating_parameter.better;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CreditValidatorTest {

    private static final int DEFAULT_PORT = 8080;

    @Test
    public void testCreate() throws Exception {
        FakeRGHConnection connection = new FakeRGHConnection();
        CreditMaster master = new CreditMaster("crm2.mas", true);

        CreditValidator validator = new CreditValidator(connection, master, "a");

        connection.report = new RFIDReport();

        Certificate result = validator.validateCustomer(new Customer(1));
        assertEquals(Certificate.VALID, result.getStatus());
    }
}
