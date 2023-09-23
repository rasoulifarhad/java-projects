package com.farhad.example.ddd_tips.application_services_security_enforcement.input_output.dto;

import java.time.LocalDate;

public interface InvoiceService {

    LocalDate findLastInvoiceDate(CustomerId id);

}
