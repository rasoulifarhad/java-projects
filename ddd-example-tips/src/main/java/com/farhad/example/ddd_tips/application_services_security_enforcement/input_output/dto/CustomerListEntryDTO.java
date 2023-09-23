package com.farhad.example.ddd_tips.application_services_security_enforcement.input_output.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerListEntryDTO {
    private CustomerId id;
    private String name;
    private LocalDate lastInvoiceDate;
}
