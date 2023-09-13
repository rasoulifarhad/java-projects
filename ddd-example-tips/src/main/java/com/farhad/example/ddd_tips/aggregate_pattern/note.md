## 

Now, the business has asked you to limit the possibility to order more than 100 hundred items or for more than $5,000.

### Aggregate Pattern

This is a classic usage example of the famous Aggregate Pattern. Although some try to identify aggregates by looking for matching domain concepts, the pattern’s real purpose is to help you ensure transactional consistency between your entities.

Order class should be an aggregate over the OrderPosition class. This implies the following:


- The Order class is responsible for ensuring the maximum amount of positions and their maximum balance.
- The Order class requires some concurrency mechanism e.g. optimistic locking (AKA versioning).
- There will be an OrderRepository class in the system, but not an OrderPositionRepository class.
- The addPosition operation has to be performed in a transaction.
