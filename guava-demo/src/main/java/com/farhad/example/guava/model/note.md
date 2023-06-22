in large applications you find yourself writing very similar predicates for types totally different but that share a common property like being related to a Customer. For example in the administration page, you may want to filter logs by customer; in the CRM page you want to filter complaints by customer.

For each such type X you’d need yet another CustomerXPredicate to filter it by customer. But since each X is related to a customer in some way, we can factor that out (Extract Interface in Eclipse) into an interface CustomerSpecific with one method:

```java
public interface CustomerSpecific {
   Customer getCustomer();
}
```

This fine-grained interface reminds me of [traits](https://en.wikipedia.org/wiki/Trait_(computer_programming)) in some languages, except it has no reusable implementation. It could also be seen as a way to introduce a touch of dynamic typing within statically typed languages, as it enables calling indifferently any object with a getCustomer() method. Of course our class PurchaseOrder now implements this interface.

Once we have this interface `CustomerSpecific`, we can define predicates on it rather than on each particular type as we did before. This helps leverage just a few predicates throughout a large project. In this case, the predicate `CustomerPredicate` is co-located with the interface `CustomerSpecific` it operates on, and it has a generic type `CustomerSpecific`:

```java
public final class CustomerPredicate implements Predicate<CustomerSpecific>, CustomerSpecific {
  private final Customer customer;
  // valued constructor omitted for clarity
  public Customer getCustomer() {
    return customer;
  }
  public boolean apply(CustomerSpecific specific) {
    return specific.getCustomer().equals(customer);
  }
}
```

**Notice that the predicate can itself implement the interface `CustomerSpecific`, hence could even evaluate itself!**

When using trait-like interfaces like that, you must take care of the generics and change a bit the method that expects a `Predicate<PurchaseOrder>` in the class `PurchaseOrders`, so that it also accepts any predicate on a supertype of `PurchaseOrder`:

```java
public Iterable<PurchaseOrder> selectOrders(Predicate<? super PurchaseOrder> condition) {
    return Iterables.filter(orders, condition);
}
```