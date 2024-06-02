package com.farhad.example.work_effevtively_with_legacy_code.wrap_class.demo2;

import java.util.Date;
import java.util.List;



// We want to log the fact that we are paying a particular employee. One thing
// that we can do is make another class that has a pay method. Objects of that
// class can hold on to an employee, do the logging work in the pay() method, and
// then delegate to the employee so that it can perform payment.
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
