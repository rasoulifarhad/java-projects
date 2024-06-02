package com.farhad.example.work_effevtively_with_legacy_code.wrap_class.demo3;

import java.util.Date;
import java.util.List;



// Let’s look at a case where we need to log calls to pay() in
// only one place. Instead of wrapping in the functionality as a decorator, we can
// put it in another class that accepts an employee, does payment, and then logs
// information about it.
public class Employee {

    private PayDispatcher payDispatcher;
    private List<TimeCard> timeCards;
    private List<Date> payPeriod;
    private double payRate;

    public void pay(Date date) {
        Money amount = new Money(0.0);
        for (TimeCard timeCard : timeCards) {
            if (payPeriod.contains(date)) {
                amount.add(timeCard.getHours() * payRate);
            }
        }
        payDispatcher.pay(this, date, amount);
    }
}
