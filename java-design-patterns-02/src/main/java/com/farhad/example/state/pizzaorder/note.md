See https://www.learncsdesign.com/learn-the-state-design-pattern/

Ordering Pizzas: The order can be in one of four states: Confirmed, Baked, Dispatched, or Delivered. 

The next method of the order works a little bit differently in each state. For instance, in Confirmed, it moves the order state to Baked. In Baked, it moves to Dispatched, and in Dispatched, it moves to Delivered.

The State design pattern suggests creating new classes for all the possible states of an object and extracting all state-specific behaviors into these classes.