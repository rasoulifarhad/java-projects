package com.farhad.example.ddd_tips.application_services_security_enforcement.input_output.dpo;

import java.time.YearMonth;
import java.util.Collection;

import lombok.Data;

@Data
public class CustomerInvoiceMonthlySummaryDPO {
    
   private Customer customer;
    private YearMonth month;
    private Collection<Invoice> invoices;

}
