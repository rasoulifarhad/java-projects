package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.Iiritating_parameter.legacy;

import org.junit.jupiter.api.Test;

public class CreditValidatorTest {

    private static final int DEFAULT_PORT = 8080;

    @Test
    public void testCreate() throws Exception {
        RGHConnection connection = new RGHConnection(DEFAULT_PORT, 
                                                     "admin", 
                                                     "123456");
        CreditMaster master = new CreditMaster("crm2.mas", true);

        CreditValidator validator = new CreditValidator(connection, master, "a");
    }
}
