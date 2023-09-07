See https://alistair.cockburn.us/hexagonal-architecture/
See https://github.com/jmgarridopaz/discounter

See also https://github.com/jmgarridopaz/coffee-machine
See also https://github.com/jmgarridopaz/hexawordle
See also https://github.com/jmgarridopaz/task-management
See also https://github.com/jmgarridopaz/lib-commandbus

Calculates the discount to substract from a given amount of money.

```
discount(amount) = amount * rate(amount)
```

The rate to apply depends on the amount, as explained below:

- The whole range of possible amount values is split into non overlapping, consecutive intervals. A concrete rate value is associated to each interval.
- The rate to be applied to an amount will be the rate value associated to the interval where the amount belongs to.
- Such intervals are created by defining the so-called Break Points. A break point is a concrete amount value, which is the edge between two consecutive intervals. It is the point where the rate value changes.
- So, intervals and their rates can be defined in a summarized way, with a table where each row is a (break point, rate value) pair, ordered by increasing break point value.

| Breaking point | rate
| -------------- | ---- | 
0 | 0
100 | 5
1000 |  7
10000 |  10