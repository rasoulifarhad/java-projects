package com.farhad.example.ddd_tips.application_services_security_enforcement.input_output.dpo;

import java.time.YearMonth;
import java.util.List;

public interface InvoiceRepository {

    List<Invoice> findByYearMonth(CustomerId customerId, YearMonth month);

}
