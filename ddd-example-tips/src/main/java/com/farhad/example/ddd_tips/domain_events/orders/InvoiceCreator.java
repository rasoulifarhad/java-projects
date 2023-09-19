package com.farhad.example.ddd_tips.domain_events.orders;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceCreator {
    final OrderRepository orderRepository;
    final InvoiceRepository invoiceRepository;

    private InvoiceFactory invoiceFactory;

    @DomainEventListener
    @Transactional
    public void onOrderShipped(OrderShipped event) {
        Order order = orderRepository.find(event.getOrder());
        Invoice invoice = invoiceFactory.createInvoiceFor(order);
        invoiceRepository.save(invoice);
    }
}
