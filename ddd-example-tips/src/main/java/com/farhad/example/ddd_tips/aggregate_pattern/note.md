## 

Now, the business has asked you to limit the possibility to order more than 100 hundred items or for more than $5,000.

### Aggregate Pattern

This is a classic usage example of the famous Aggregate Pattern. Although some try to identify aggregates by looking for matching domain concepts, the pattern’s real purpose is to help you ensure transactional consistency between your entities.

Order class should be an aggregate over the OrderPosition class. This implies the following:


- The Order class is responsible for ensuring the maximum amount of positions and their maximum balance.
- The Order class requires some concurrency mechanism e.g. optimistic locking (AKA versioning).
- There will be an OrderRepository class in the system, but not an OrderPositionRepository class.
- The addPosition operation has to be performed in a transaction.

### Keep The Aggregates Small

The business asks you to change the status to PAID once 99% of the order value is paid, to IN_DELIVERY once the guy at the warehouse starts to fill the parcels, and to COMPLETED once all parcels are delivered.

Does that mean that the Order class should now take care of payments, parcels, and tracking the guy at the warehouse? The resulting aggregate would be a giant class with lots of responsibilities, just for the sake of maintaining consistency. Also, performance would suffer badly and the risk of a failed transaction would grow significantly. That’s a pretty extreme vision, but it shows the limits of the Aggregate pattern's applicability.

### Eventual Consistency

Things are usually not that bad. If you go and ask the business whether it’s okay for the order status to be updated a few seconds after the payment has been received or the parcel is delivered, they will most likely answer positively.

### Reference by ID

Taking the concepts above even further, if we only want to update one aggregate per transaction and we strive to keep the aggregates small, one could employ the practice of referencing other aggregates only by ID. It further reduces the aggregate, as we’re keeping an ID instead of an object, and allows for better scaling, as we’re no longer forcing ourselves to load multiple aggregates in the same database query. Plus, we’re less tempted to update multiple aggregates at once.
