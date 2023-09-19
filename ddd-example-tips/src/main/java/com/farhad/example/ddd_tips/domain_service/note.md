Going to create a domain service that checks whether a certain monetary transaction is allowed to proceed or not. 

Since the business logic is so simple, you might have been able to add it directly to the `Account` class. However, as soon as more advanced business rules come into play it makes sense to move the decision making into its own class (especially if the rules change over time or depend on some external configuration). Another telltale sign that this logic may belong in a domain service is that it involves multiple aggregates (two accounts).

In the second example(CurrencyExchangeService), we are going to look at a domain service that has a special feature: its interface is part of the domain model but its implementation is not. This is a situation that may arise when you need information from the outside world in order to make a business decision inside your domain model, but you are not interested in where that information is coming from.

```java
public interface CurrencyExchangeService {

    Money convertToCurrency(Money currentAmount, Currency desiredCurrency);
}

```

When the domain model is wired up, for example using a dependency injection framework, you can then inject the correct implementation of this interface. You could have one that invokes a local cache, another that invokes a remote web service, a third that is used for testing only and so on.

factories

In this example, we are going to look at a factory that is translating between two bounded contexts. In the shipment context, the `customer` is no longer referred to as a `customer` but as a `shipment recipient`. The **customer ID** is still stored so that we can relate the two concepts together later if needed.

```java
public class ShipmentRecipientFactory {
    private final PostOfficeRepository postOfficeRepository;
    private final StreetAddressRepository streetAddressRepository; 

    // Initializing constructor omitted

    ShipmentRecipient createShipmentRecipient(Customer customer) {
        var postOffice = postOfficeRepository.findByPostalCode(customer.postalCode());
        var streetAddress = streetAddressRepository.findByPostOfficeAndName(postOffice, customer.streetAddress());
        var recipient = new ShipmentRecipient(customer.fullName(), streetAddress);
        recipient.associateWithCustomer(customer.id());
        return recipient;
    }
}
```