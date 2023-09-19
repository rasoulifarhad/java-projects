package com.farhad.example.ddd_tips.factories;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShipmentRecipientFactory {
    
    private final PostOfficeRepository postOfficeRepository;
    private final StreetAddressRepository streetAddressRepository;

    public ShipmentRecipient createShipmentRecipient(Customer customer) {
        PostOffice postOffice = postOfficeRepository.findByPostalCode(customer.postalCode());
        StreetAddress streetAddress = streetAddressRepository.findByPostOfficeAndName(postOffice, customer.streetAddress());
        ShipmentRecipient recipient = new ShipmentRecipient(customer.fullName(), streetAddress);
        recipient.associateWithCustomer(customer.id());
        return recipient;
    }
}
