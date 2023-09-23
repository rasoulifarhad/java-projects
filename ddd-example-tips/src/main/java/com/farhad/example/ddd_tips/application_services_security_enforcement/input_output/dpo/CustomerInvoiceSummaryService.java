package com.farhad.example.ddd_tips.application_services_security_enforcement.input_output.dpo;

import java.time.YearMonth;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerInvoiceSummaryService {
    
    private CustomerRepository customerRepository;
    private InvoiceRepository invoiceRepository;

    public CustomerInvoiceMonthlySummaryDPO getMonthlySummary(CustomerId customerId, YearMonth month) {

        Customer customer = customerRepository.findById(customerId);
        List<Invoice> invoices = invoiceRepository.findByYearMonth(customerId, month);
        CustomerInvoiceMonthlySummaryDPO dpo = new CustomerInvoiceMonthlySummaryDPO();
        dpo.setCustomer(customer);
        dpo.setMonth(month);
        dpo.setInvoices(invoices);
        return dpo;
    }    
}
