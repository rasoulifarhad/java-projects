package com.farhad.example.ddd_tips.domain_events.orders;

public interface InvoiceRepository {

    void save(Invoice invoice);
    
}
