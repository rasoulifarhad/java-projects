package com.farhad.example.ddd_tips.application_services_security_enforcement.input_output.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class CustomerListingService {
    
    private  CustomerRepository customerRepository;

    private InvoiceService invoiceService;

   
    @Transactional
    public List<CustomerListEntryDTO> getCustomerList() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerListEntryDTO> dtos = new ArrayList<>();
        for (Customer customer : customers) {
            LocalDate lastInvoiceDate = invoiceService.findLastInvoiceDate(customer.getId());
            CustomerListEntryDTO dto = new CustomerListEntryDTO();
            dto.setId(customer.getId());
            dto.setName(customer.getName());
            dto.setLastInvoiceDate(lastInvoiceDate);
            dtos.add(dto);
        }
        return dtos;
    }
}
