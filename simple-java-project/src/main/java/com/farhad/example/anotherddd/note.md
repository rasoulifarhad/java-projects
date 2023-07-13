## Services and the double dispatch pattern

The double dispatch pattern is quite simple.

> mIt involves passing an object to a method, and the method body calls another method on the passed in object, usually passing in itself as an argument.  

```java
public interface BalanceCalculator {
    BigDecimal calculate(Fee fee);
}
```

The signature of the method is important.  It accepts a `Fee` object, but returns the total directly.  It doesn’t try to modify the `Fee``, allowing for a side-effect free function.  


> We can call the calculator as many times as we like with a given `Fee`, and we can be assured that the `Fee` object won’t be changed.

<br/>

> From the Fee side, we now need to use this service as part of recording a payment.

> One of the features requested for our Customer object is:  


>> We need to know if a customer has an outstanding balance on more than 3 fees. If a Customer has more than 3 fees with an outstanding balance, we flag them as AtRisk.  When a customer pays off a fee and they no longer have more than 3 fees outstanding, they are no longer at risk.  


Note: When a fee as been paid off, the customer needs to be notified that to update their AtRisk flag.

note: Whenever we hear the word “When”, that should be a signal to us that there is a potential event in our system.  We would like to model this event explicitly in our system and to have our model reflect this kind of relationship between Fee and Customer. 
