package com.farhad.example.work_effevtively_with_legacy_code.wrap_method.demo02;

import java.util.Date;
import java.util.List;

public class Employee {

    private PayDispatcher payDispatcher;
    private List<TimeCard> timeCards;
    private List<Date> payPeriod;
    private double payRate;

    public void makeLoggedPaymrnt(Date date) {
        logPayment();
        dispatchPayment(date);
    }

    private void dispatchPayment(Date date) {
        Money amount = new Money(0.0);
        for (TimeCard timeCard : timeCards) {
            if (payPeriod.contains(date)) {
                amount.add(timeCard.getHours() * payRate);
            }
        }
        payDispatcher.pay(this, date, amount);
    }

    private void logPayment() {
    }
}
